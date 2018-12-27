class Solution {
  public int searchInsert(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left + 1 < right) {
          int mid = left + (right - left) / 2;
          if (nums[mid] == target) {
              return mid;
          } else if (nums[mid] < target) {
              left = mid;
          } else {
              right = mid;
          }
      }
      if (nums[left] == target) {
          return left;
      }
      if (nums[right] == target) {
          return right;
      }
      if (nums[left] < target && nums[right] < target) {
          return right + 1;
      }
      if (nums[left] < target) {
          return right;
      }
      return left;
  }
}
// [1, 3, 5, 6] 2
// [1, 3]