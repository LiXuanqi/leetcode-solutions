class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> graph = buildGraph(prerequisites);
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            for (int num : entry.getValue()) {
                indegrees.put(num, indegrees.getOrDefault(num, 0) + 1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!indegrees.containsKey(i)) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            // System.out.println(curr);
            visited[curr] = true;
            if (graph.containsKey(curr)) {
                for (int nextNode : graph.get(curr)) {
                    indegrees.put(nextNode, indegrees.get(nextNode) - 1);
                    if (indegrees.get(nextNode) == 0) {
                        queue.offer(nextNode);
                    }
                }   
            }
          
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
            // System.out.print(visited[i] + " ");
        }
        return true;
    }
    private Map<Integer, Set<Integer>> buildGraph(int[][] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i][1])) {
                map.put(nums[i][1], new HashSet<>());
            }
            map.get(nums[i][1]).add(nums[i][0]);
        }
        return map;
    }
}