class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }     
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[start];
        }
        
        int left = start;
        int right = end;
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            // why not quickSelect(nums.left, end, k - (left - start));
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
        
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}