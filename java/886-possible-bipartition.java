class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0 || dislikes[0].length != 2) {
            return true;
        }
        Map<Integer, List<Integer>> graph = buildGraph(dislikes);
        int[] colors = new int[N + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (colors[i] != 0) {
                continue;
            }
            queue.offer(i);
            colors[i] = 1;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (!graph.containsKey(curr)) {
                    continue;
                }
                for (int neighbor : graph.get(curr)) {
                    if (colors[neighbor] == colors[curr]) {
                        return false;
                    }
                    if (colors[neighbor] != 0) {
                        continue;
                    }
                    queue.offer(neighbor);
                    colors[neighbor] = -colors[curr];
                }
            }
        }
        return true;
        
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : dislikes) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}