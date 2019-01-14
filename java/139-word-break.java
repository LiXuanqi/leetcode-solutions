class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        if (s == null || s.length() == 0) {
            return true;
        }
        // get max length
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for (int i = 1; i < dp.length; i++) {
            int start = Math.max(0, i - maxLength);
            for (int j = start; j < i; j++) {
                if (dict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}