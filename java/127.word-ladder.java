class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.offer(beginWord);
        used.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return count;
                }
                for (String next : getNextWords(curr, dict)) {
                    if (!used.contains(next)) {
                        queue.offer(next);
                        used.add(next);
                    }
                }
            }
            
        }
        return 0;
    }
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> ans = new ArrayList<>();
        char[] input = word.toCharArray();
        for (int i = 0; i < input.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = input[i];
                input[i] = c;
                String newWord = String.valueOf(input);
                if (dict.contains(newWord)) {
                    ans.add(newWord);
                }
                input[i] = temp; // recover
            }
        }
        return ans;
    }
}