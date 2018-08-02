class Solution {
  public int maxSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      int dp = nums[0];
      int max = nums[0];
      for (int i = 1; i < nums.length; i++) {
          if (dp < 0) {
              dp = nums[i];
          } else {
              dp = dp + nums[i];
          }
          max = Math.max(max, dp);
      }
      return max;
  }
}