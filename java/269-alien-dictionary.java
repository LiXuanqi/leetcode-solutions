class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }
        
        Map<Character, Integer> indegree = new HashMap<>();
        // init indegree
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                indegree.put(word.charAt(i), 0);
            }
        }
        
        Map<Character, Set<Character>> graph = buildGraph(words);
        System.out.println(graph);
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            for (char c : entry.getValue()) {
                indegree.put(c, indegree.getOrDefault(c, 0) + 1);
            }
        }
          System.out.println(indegree);
        Queue<Character> queue = new LinkedList<>();
        
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        // System.out.println(indegree);
        StringBuilder result = new StringBuilder();
        
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            if (graph.get(curr) != null) {
                for (char nextNode : graph.get(curr)) {
                    indegree.put(nextNode, indegree.get(nextNode) - 1);
                    if (indegree.get(nextNode) == 0) {
                        queue.offer(nextNode);
                    }
                }
            }
        }
        String resultStr = result.toString();
        return resultStr.length() == indegree.size() ? resultStr : "";
        
    }
    
    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {  
            for (int j = i + 1; j < words.length; j++) {
                String word1 = words[i];
                String word2 = words[j];
                int length = Math.min(word1.length(), word2.length());           
                for (int k = 0; k < length; k++) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        if (!graph.containsKey(word1.charAt(k))) {
                            graph.put(word1.charAt(k), new HashSet<>());
                        }
                        graph.get(word1.charAt(k)).add(word2.charAt(k));
                        break;
                    }
           
                }
            }
        }
        return graph;
    }
}