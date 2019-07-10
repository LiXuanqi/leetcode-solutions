class Solution {
  public int findLengthOfLCIS(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      int max = 1;
      int[] dp = new int[nums.length];
      dp[0] = 1;
      for (int i = 1; i < nums.length; i++) {
          dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
          if (dp[i] > max) {
              max = dp[i];
          }
      }
      return max;
  }
}