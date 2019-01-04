class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int maxLength = getMaxLength(wordDict);
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            boolean isMatch = false;
            for (int j = Math.max(0, i - maxLength); j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    isMatch = true;
                }
            }
            dp[i] = isMatch;
        }
        return dp[dp.length - 1];
    }
    private int getMaxLength(List<String> words) {
        int max = Integer.MIN_VALUE;
        for (String word : words) {
            max = Math.max(word.length(), max);
        }
        return max;
    }
}