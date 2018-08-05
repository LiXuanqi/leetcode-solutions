class Solution {
  public int maximalSquare(char[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return 0;
      }
  
      int[][] dp = new int[matrix.length][matrix[0].length];
      // init dp
      int result = 0;
      for (int i = 0; i < matrix.length; i++) {
          dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
          if (dp[i][0] > result) {
              result = dp[i][0];
          }
      }
      for (int i = 0; i < matrix[0].length; i++) {
          dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
          if (dp[0][i] > result) {
              result = dp[0][i];
          }
      }
      
      for (int i = 1; i < matrix.length; i++) {
          for (int j = 1; j < matrix[0].length; j++) {
              if (matrix[i][j] == '0') {
                  dp[i][j] = 0;
                  continue;
              }
              dp[i][j] = minOfThree(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
              if (dp[i][j] > result) {
                  result = dp[i][j];
              }
          }
      }
      return result * result;
  }
  private int minOfThree(int a, int b, int c) {
      return Math.min(a, Math.min(b, c));
  }
}