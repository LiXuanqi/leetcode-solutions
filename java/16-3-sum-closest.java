class Solution {
  public int threeSumClosest(int[] nums, int target) {
      if (nums == null) {
          return Integer.MAX_VALUE; // invalid.
      }
      Arrays.sort(nums);
      int result = nums[0] + nums[1] + nums[2];
      for (int i = 0; i < nums.length - 2; i++) {
          int left = i + 1;
          int right = nums.length - 1;
          while (left < right) {
              int sum = nums[i] + nums[left] + nums[right];
              if (Math.abs(sum - target) < Math.abs(result - target)) {
                  result = sum;
              }
              if (sum < target) {
                  left++;
              } else {
                  right--;
              }
          }
      }
      return result;
  }
}
