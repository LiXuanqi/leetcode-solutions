class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        // prefix sum
        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = 1; j < dp[0].length; j++) {
                sum += matrix[i - 1][j - 1];
                dp[i][j] = dp[i - 1][j] + sum;
            }
        }
        // print(dp);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > row2 || col1 > col2) {
            return -1;
        }
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
    // private void print(int[][] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < nums[0].length; j++) {
    //             System.out.print(nums[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */