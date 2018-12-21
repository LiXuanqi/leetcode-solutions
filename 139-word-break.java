class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            boolean isMatch = false;
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (i - word.length() >= 0 && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                    isMatch = true;
                }
            }
            dp[i] = isMatch;
        }
        return dp[dp.length - 1];                                                                               
    }
}