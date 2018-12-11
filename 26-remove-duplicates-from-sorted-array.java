class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 1;
        int right = 0;
        while (right < nums.length) {
            if (nums[left - 1] == nums[right]) {
                right++;
            } else {
                nums[left++] = nums[right++];
            }
        }
        return left;
    }
}