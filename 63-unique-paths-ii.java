class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        // init dp
        dp[row - 1][col - 1] = obstacleGrid[row - 1][col - 1] == 1 ? 0 : 1;
        for (int i = 1; i <= col - 1; i++) {
            dp[row - 1][col - 1 - i] = obstacleGrid[row - 1][col - 1 - i] == 0 ? dp[row - 1][col - i] : 0;
        }
        for (int i = 1; i <= row - 1; i++) {
            dp[row - 1 - i][col - 1] = obstacleGrid[row - 1 - i][col - 1] == 0 ? dp[row - i][col - 1] : 0;
        }
        // dp
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= col - 1; j++) {
                dp[row - 1 - i][col - 1 - j] = obstacleGrid[row - 1 - i][col - 1 - j] != 1 ? (dp[row - i][col - 1 - j] + dp[row - 1 - i][col - j]) : 0;
            }
        }
        return dp[0][0];
    }
}

// Time = O(n^2)
// Space = O(n^2) could be optimized to O(n)