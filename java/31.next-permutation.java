class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int pivot = nums.length - 1;
        while (pivot > 0 && nums[pivot - 1] >= nums[pivot]) {
            pivot--;
        }
        if (pivot == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int needChange = pivot - 1;
        int largerThanNeedChange = nums.length - 1;
        while (largerThanNeedChange > needChange && nums[largerThanNeedChange] <= nums[needChange]) {
            largerThanNeedChange--;
        }
        swap(nums, needChange, largerThanNeedChange);
        reverse(nums, needChange + 1, nums.length - 1);
        return;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}