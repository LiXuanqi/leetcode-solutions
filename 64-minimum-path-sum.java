class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int i = 1; i <= col - 1; i++) {
            dp[row - 1][col - 1 - i] = grid[row - 1][col - 1 - i] + dp[row - 1][col - i];
        }
        for (int i = 1; i <= row - 1; i++) {
            dp[row - 1 - i][col - 1] = grid[row - 1 - i][col - 1] + dp[row - i][col - 1];
        }
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= col - 1; j++) {
                dp[row - 1 - i][col - 1 - j] = Math.min(dp[row - i][col - 1 - j], dp[row - 1 - i][col - j]) + grid[row - 1 - i][col - 1 - j];
            }
        }
        return dp[0][0];
    }
}