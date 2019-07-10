class Solution {
  public boolean canJump(int[] nums) {
      int maxLength = 0;
      for (int i = 0; i < nums.length; i++) {
          if (i > maxLength) {
              break;
          }
          maxLength = Math.max(maxLength, i + nums[i]);
      }
      if (maxLength >= nums.length - 1) {
          return true;
      }
      return false;
  }
}