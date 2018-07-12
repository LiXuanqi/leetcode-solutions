class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i = 1;
        int j = 1;
        while (j < nums.length) {
            if (nums[i - 1] != nums[j]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
// Time = O(n)
// Space = O(1)