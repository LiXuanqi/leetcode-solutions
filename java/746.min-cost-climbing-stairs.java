class Solution {
  public int minCostClimbingStairs(int[] costs) {
      int[] dp = new int[costs.length + 1];
      dp[0] = 0;
      dp[1] = 0;
      for (int i = 2; i < dp.length; i++) {
        int case1 = dp[i - 2] + costs[i - 2];
        int case2 = dp[i - 1] + costs[i - 1];
        dp[i] = Math.min(case1, case2);
      }
      return dp[dp.length - 1];
  }
}