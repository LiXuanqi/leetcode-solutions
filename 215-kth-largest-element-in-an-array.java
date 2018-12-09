class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return -1; // invalid input.
        }
        return helper(nums, k, 0, nums.length - 1);
    }
    private int helper(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        // partition.
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            // after swap, it might be right | (element) | left
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        // on the left side.
        if (right - start + 1 >= k) {
            return helper(nums, k, start, right);
        }
        // on the right side.
        // left - start = (left - 1) - start + 1
        if (k > left - start) {
            return helper(nums, k - (left - start), left, end);
        }
        return nums[right + 1];
        
    }
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}