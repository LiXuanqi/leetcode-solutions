class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int ans = words.length;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                p1 = i;
            } else if (word.equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                int diff = Math.abs(p2 - p1);
                ans = Math.min(ans, diff);
            }
        }
        return ans;
    }
}