class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        // m = 7 n = 3
        int[][] dp = new int[n][m];
        // init
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = 1;
        }
        // dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[n - 1 - i][m - 1 - j] = dp[n - 1 - i][m - j] + dp[n - i][m - 1 - j];
            }
        }
        return dp[0][0];
    }
}
