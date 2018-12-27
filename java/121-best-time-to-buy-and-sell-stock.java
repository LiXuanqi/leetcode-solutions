class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int lowest = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            if (price < lowest) {
                lowest = price;
            } else {
                int profit = price - lowest;
                ans = Math.max(ans, profit);
            }
        }
        return ans;
    }
}