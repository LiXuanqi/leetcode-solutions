class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        for (int num : nums) {
            if (num != nums[max] && num * 2 > nums[max]) {
                return -1;
            }
        }
        return max;
    }
}