class Solution {
    class Edge {
        String to;
        boolean used;
        public Edge(String to) {
            this.to = to;
        }
    }
    public List<String> findItinerary(String[][] tickets) {
        List<String> path = new LinkedList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length != 2) {
            return path;
        }
        Map<String, List<Edge>> graph = buildGraph(tickets);
        visit(graph, "JFK", path);
        return path;
    }
    private void visit(Map<String, List<Edge>> graph, String start, List<String> path) {
        // No flight starts from here.
        if (!graph.containsKey(start)) {
            path.add(0, start);
            return;
        }
        for (Edge edge : graph.get(start)) {
            if (!edge.used) {
                edge.used = true;
                visit(graph, edge.to, path);
            }
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
        for (List<Edge> value : graph.values()) {
            Collections.sort(value, (e1, e2) -> {
                return e1.to.compareTo(e2.to);
            });
        }
        return graph;
    }
}