class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || values == null || equations.length == 0 || values.length == 0 || equations.length != values.length) {
           return null; 
        }
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        // System.out.println(graph);
        double[] result = new double[queries.length];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            double val = 0;
            if (!query[0].equals(query[1])) {
                visited.add(query[0]);
                val = dfs(query[0], query[1], graph, visited, 1.0);
                visited.remove(query[0]);
            } else {
                if (graph.containsKey(query[0])) {
                    val = 1.0;
                }
            }
           
            result[i] = val == 0.0 ? -1.0 : val;
        }
        return result;
    }
    private double dfs(
        String start,
        String end,
        Map<String, Map<String, Double>> graph,
        Set<String> visited,
        double val
    ) {
        // System.out.println(start);
        // System.out.println(end);
        if (start.equals(end)) {
            return val;
        }
        if (!graph.containsKey(start)) {   
            // System.out.println(graph);
            return 0.0;
        }
        visited.add(start);
        Map<String, Double> edges = graph.get(start);
        double temp = 0.0;
        for (String node : edges.keySet()) {
            if (visited.contains(node)) {
                continue;
            }
            temp = dfs(node, end, graph, visited, val * edges.get(node));
            if (temp != 0.0) {
                break;
            }
        }
        visited.remove(start);
        return temp;
    }
    private Map<String, Map<String, Double>> buildGraph(String[][] equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] edge = equations[i];
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new HashMap<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new HashMap<>());
            }
            map.get(edge[0]).put(edge[1], values[i]);
            map.get(edge[1]).put(edge[0], 1 / values[i]);
        }
        return map;
    }
}