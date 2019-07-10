class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        int maxProfit = 0;
        if (k * 2 >= prices.length) {
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    maxProfit += prices[i + 1] - prices[i];
                }
            }
            return maxProfit;
        } else {
            long[][] dp = new long[prices.length][2 * k + 1];
            dp[0][0] = 0;
            dp[0][1] = - prices[0];
            for (int i = 2; i < dp[0].length; i++) {
                dp[0][i] = Integer.MIN_VALUE;
            }
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = dp[i - 1][0];
                for (int j = 1; j < dp[0].length; j++) {
                    // sell
                    if (j % 2 == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + prices[i]);
                        maxProfit = Math.max(maxProfit, (int) dp[i][j]);
                    } else {
                    // buy
                       dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] - prices[i]); 
                    }
                }
            }
            return maxProfit;
        }
    }
}