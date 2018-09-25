class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int lowestPrice = Integer.MAX_VALUE;
        int biggestProfit = 0;
        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else {
                int profit = price - lowestPrice;
                biggestProfit = Math.max(biggestProfit, profit);
            }
        }
        return biggestProfit;
    }
}