class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        boolean isFirst = true;
        while (isFirst || slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            isFirst = false;
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}