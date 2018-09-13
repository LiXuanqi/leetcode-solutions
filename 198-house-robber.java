class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rob = 0;
        int notRob = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentRob = notRob + nums[i];
            notRob = Math.max(notRob, rob);
            rob = currentRob;
        }
        return Math.max(notRob, rob);
    }
}