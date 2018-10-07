class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int[] used = new int[graph.length];
        // 0 - not used.
        // 1 - group 1
        // -1 - group 2.
        
        for (int i = 0; i < graph.length; i++) {
            if (used[i] != 0) {
                continue;
            }
            // bfs
     
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            used[i] = 1;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int j = 0; j < graph[node].length; j++) {
                    int nextNode = graph[node][j];
                    if (used[nextNode] == used[node]) {
                        return false;
                    }
                    if (used[nextNode] == 0) {
                        queue.offer(nextNode);
                        used[nextNode] = -used[node];
                    }
                }    
            }
        }
        return true;
    }
}