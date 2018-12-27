class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        long[][] dp = new long[prices.length][4];
        // 0: unhold, nothing.
        // 1: unhold, sell.
        // 2: hold, nothing.
        // 3: hold, buy.
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        dp[0][3] = -prices[0];
        int maxProfit = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][0] - prices[i];
            
            maxProfit = Math.max(maxProfit, (int) dp[i][0]);
            maxProfit = Math.max(maxProfit, (int) dp[i][1]);
        }
        return maxProfit;
    }
}