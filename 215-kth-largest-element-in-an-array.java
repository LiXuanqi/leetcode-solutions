class Solution {
  public int findKthLargest(int[] nums, int k) {
      Arrays.sort(nums);
      return nums[nums.length - k];
  }
}

// sort: O(nlogn)
// heapify: O(n + k)
// max heap: O((n + k)logn)
// min heap: O(nlogk)
// quick selection: 