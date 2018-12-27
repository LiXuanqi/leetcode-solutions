class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.offer(beginWord);
        used.add(beginWord);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return ans + 1;
                }
                for (String neighbor : getNeighbors(curr, dict)) {
                    if (!used.contains(neighbor)) {
                        queue.offer(neighbor);
                        used.add(neighbor);
                    }
                }
            }
            ans++;
        }
        return 0;
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        char[] input = word.toCharArray();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = input[i];
                input[i] = c;
                String newWord = new String(input);
                input[i] = temp;
                if (dict.contains(newWord)) {
                    words.add(newWord);
                }
            }
        }
        return words;
    }
}