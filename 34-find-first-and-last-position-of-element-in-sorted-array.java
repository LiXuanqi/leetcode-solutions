class Solution {
  public int[] searchRange(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
          return new int[]{-1, -1};
      }
      int first = findFirstPosition(nums, target);
      int end = findEndPosition(nums, target);
      return new int[]{first, end};
  }
  private int findFirstPosition(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          if (nums[mid] >= target) {
              end = mid;
          } else  {
              start = mid;
          } 
      }
      if (nums[start] == target) {
          return start;
      }
      if (nums[end] == target) {
          return end;
      }
      return -1;
  }
  private int findEndPosition(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          if (nums[mid] <= target) {
              start = mid;
          } else {
              end = mid;
          }
      }
      if (nums[end] == target) {
          return end;
      }
      if (nums[start] == target) {
          return start;
      }
      return -1;
  }
}