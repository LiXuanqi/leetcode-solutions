class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0 || fee < 0) {
            return 0;
        }
        long[][] dp = new long[prices.length][2]; // 0: don't have, 1: have
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            maxProfit = Math.max(maxProfit, (int) dp[i][0]);
        }
        return maxProfit;
    }
}