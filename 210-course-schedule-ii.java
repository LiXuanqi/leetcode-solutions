class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        int count = 0;
        Map<Integer, Set<Integer>> graph = buildGraph(prerequisites);
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            for (int node : entry.getValue()) {
                indegrees.put(node, indegrees.getOrDefault(node, 0) + 1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegrees.containsKey(i)) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[count++] = curr;
            if (graph.containsKey(curr)) {
                for (int nextNode : graph.get(curr)) {
                    indegrees.put(nextNode, indegrees.get(nextNode) - 1);
                    if (indegrees.get(nextNode) == 0) {
                        queue.offer(nextNode);
                    }
                }  
            }  
        }
        return (count == numCourses) ? result : new int[0];
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