class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = 0;
        int sell = 0;
        boolean isHandEmpty = true;
        for (int i = 0; i < prices.length - 1; i++) {
            // buy
            if (prices[i] < prices[i + 1]) {
                if (isHandEmpty) {
                    buy += prices[i];
                    isHandEmpty = !isHandEmpty;
                    System.out.println("buy" + i + " " + buy);
                    
                }
            } else { // sell
                if (!isHandEmpty) {
                    sell += prices[i];
                    isHandEmpty = !isHandEmpty;
                    System.out.println("sell" + i + " " + sell);
                }
            }
        }
        if (!isHandEmpty) {
            sell += prices[prices.length - 1];
        }
        return sell - buy;
    }
}