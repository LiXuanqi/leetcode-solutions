class Solution {
  public int minDistance(String word1, String word2) {
      if (word1 == null || word2 == null) {
          return -1;
      }
      if (word1.length() == 0) {
          return word2.length();
      }
      if (word2.length() == 0) {
          return word1.length();
      }
      int[][] dp = new int[word1.length() + 1][word2.length() + 1];
      // init dp[].
      for (int i = 0; i <= word1.length(); i++) {
          dp[i][0] = i;
      }
      for (int i = 0; i <= word2.length(); i++) {
          dp[0][i] = i;
      }
      for (int i = 1; i <= word1.length(); i++) {
          for (int j = 1; j <= word2.length(); j++) {
              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1];
              } else {
                  dp[i][j] = minOfThree(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
              }
          }
      }
      return dp[word1.length()][word2.length()];
  }
  private int minOfThree(int a, int b, int c) {
      return Math.min(a, Math.min(b, c));
  }
}