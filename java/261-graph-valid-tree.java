class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        // visit all nodes.
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (!graph.containsKey(node1)) {
                graph.put(node1, new ArrayList<>());
            }
            if (!graph.containsKey(node2)) {
                graph.put(node2, new ArrayList<>());
            }
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        // iterate
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // generate
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int neighbor : graph.get(node)) {
                if (visited[neighbor]) {
                    continue;
                }
                queue.offer(neighbor);
                visited[neighbor] = true;
            }
        }
        // check all visited.
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}