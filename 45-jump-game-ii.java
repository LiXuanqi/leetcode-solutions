class Solution {
  public int jump(int[] nums) {
      if (nums == null) {
          return -1;
      }
      int[] dp = new int[nums.length];
      dp[dp.length - 1] = 0;
      for (int i = dp.length - 2; i >= 0; i--) {
          int minCost = Integer.MAX_VALUE - 1;
          for (int j = i + 1; j <= Math.min(i + nums[i], dp.length - 1); j++) {
              minCost = Math.min(minCost, dp[j]);
          }
          dp[i] = minCost + 1;
      }
      return dp[0];
  }
}