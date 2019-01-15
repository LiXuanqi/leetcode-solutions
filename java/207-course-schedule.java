class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length != 2) {
            return true;        
        }
        Map<Integer, List<Integer>> map = buildGraph(prerequisites);
        // count indegrees
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int course : entry.getValue()) {
                indegrees.put(course, indegrees.getOrDefault(course, 0) + 1);
            }
        }
        // bfs for indegree = 0
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegrees.containsKey(i)) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (map.containsKey(curr)) {
                for (int next : map.get(curr)) {
                    indegrees.put(next, indegrees.get(next) - 1);
                    if (indegrees.get(next) == 0 && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }
    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        return map;
    }
}