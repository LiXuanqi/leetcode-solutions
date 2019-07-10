class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            // look 2th character before.
            if (left <= 1) {
                nums[left++] = nums[right++];
            } else {
                if (nums[left - 2] != nums[right]) {
                    nums[left++] = nums[right++];
                } else {
                    right++;
                }
            }
        }
        return left;
    }
}
