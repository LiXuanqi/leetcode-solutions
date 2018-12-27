class Solution {
    public int minCost(int[][] costs) {
       
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][3];
        // j = 0 : red, 
        // 1 : green
        // 2 : blue
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                int min = getMinCost(dp, i, j);
                dp[i][j] = min + costs[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
	    for (int i = 0; i <= 2; i++) {
		    ans = Math.min(ans, dp[dp.length - 1][i]);
        }
        return ans;
    }
    private int getMinCost(int[][] dp, int index, int color) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i++) {
            if (color == i) {
                continue;
            }
	        minCost = Math.min(minCost, dp[index - 1][i]);
        }
            return minCost;
    }

}