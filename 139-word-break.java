class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      if (s == null || s.length() == 0) {
          return true;
      }
      if (wordDict == null || wordDict.size() == 0) {
          return false;
      }
      Set<String> set = new HashSet<>(wordDict);
      int maxLength = 0;
      for (String word : wordDict) {
          if (word.length() > maxLength) {
              maxLength = word.length();
          }
      }
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
      for (int i = 1; i <= s.length(); i++) {
          dp[i] = false;
          for (int j = Math.max(0, i - maxLength - 1); j < i; j++) {
              if (dp[j] && set.contains(s.substring(j, i))) {
                  dp[i] = true;
              }
          }
      }
      return dp[dp.length - 1];
  }
}