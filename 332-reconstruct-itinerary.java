class Solution {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2) {
            return null;
        }
        Map<String, List<String>> graph = buildGraph(tickets);
        List<String> path = new ArrayList<>();
        path.add("JFK");
        if (dfs(graph, path, tickets.length + 1, "JFK")) {
            return path;
        }
        return null;
    }
    private boolean dfs(Map<String, List<String>> graph, List<String> path, int targetNum, String start) {
        if (path.size() == targetNum) {
            return true;
        }
        if (!graph.containsKey(start)) {
            return false;
        }
        List<String> neighbors = graph.get(start);
        for (int i = 0; i < neighbors.size(); i++) {
            String neighbor = neighbors.get(i);
            neighbors.remove(i);
            path.add(neighbor);
            if (dfs(graph, path, targetNum, neighbor)) {
                return true;
            }
            path.remove(path.size() - 1);
            neighbors.add(i, neighbor);
        }
        return false;
    }
    private Map<String, List<String>> buildGraph(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);
        }
        for (List<String> list : graph.values()) {
            Collections.sort(list);
        }
        return graph;
    }
}