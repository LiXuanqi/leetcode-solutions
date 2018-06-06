class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
      int[] result = new int[0];
      if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
          return result;
      }
      if (nums1.length > nums2.length) {
          Arrays.sort(nums2);
          result = findIntersection(nums2, nums1);
      } else {
          Arrays.sort(nums1);
          result = findIntersection(nums1, nums2);
      }   
      return result;
  }
  private int[] findIntersection(int[] nums, int[] targets) {
      HashSet<Integer> set = new HashSet<>();
      for (int target : targets) {
          if (binarySearch(nums, target)) {
              set.add(target);
          }
      }
      return set.stream().mapToInt(Number::intValue).toArray();
  }
  private boolean binarySearch(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          if (nums[mid] == target) {
              return true;
          } else if (nums[mid] < target) {
              start = mid;
          } else {
              end = mid;
          }
      }
      if (nums[start] == target) {
          return true;
      }
      if (nums[end] == target) {
          return true;
      }
      return false;
  }
}

// nlogn + mlogn = (m + n)logn
// so sort the array whose length is short.