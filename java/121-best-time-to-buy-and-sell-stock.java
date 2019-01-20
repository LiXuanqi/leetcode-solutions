class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int lowest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < lowest) {
                lowest = price;
            } else {
                int diff = price - lowest;
                ans = Math.max(ans, diff);
            }
        }
        return ans;
    }
}