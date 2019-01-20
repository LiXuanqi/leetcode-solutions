class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 0: hold
        // 1: not hold
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0] - fee;
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;
    }
}