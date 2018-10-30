// Method 1: DFS
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

// Method 2: hierholzer
class Solution {
    class Edge {
        String to;
        boolean used;
        public Edge(String to) {
            this.to = to;
        }
    }
    private List<String> path = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2) {
            return null;
        }
        Map<String, List<Edge>> graph = buildGraph(tickets);
        visit("JFK", graph);
        return path;
    }
    private void visit(String start, Map<String, List<Edge>> graph) {
        if (!graph.containsKey(start)) {
            path.add(0, start);
            return;
        }
        for (Edge edge : graph.get(start)) {
            if (edge.used) {
                continue;
            }
            edge.used = true;
            visit(edge.to, graph);
        }
        path.add(0, start);
    }
    private Map<String, List<Edge>> buildGraph(String[][] tickets) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(new Edge(to));
        }
        for (List<Edge> list : graph.values()) {
            Collections.sort(list, (e1, e2) -> {
                return e1.to.compareTo(e2.to);
            });
        }
        return graph;
    }
}