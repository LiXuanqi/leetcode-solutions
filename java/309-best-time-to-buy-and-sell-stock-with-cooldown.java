class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 0: hold
        // 1: not hold, sell
        // 2: not hold, not sell
        long[][] dp = new long[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, (int) dp[i][1]);
            ans = Math.max(ans, (int) dp[i][2]);
        }
        return ans;
    }
}
