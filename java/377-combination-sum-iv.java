class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int total = 0;
            for (int num : nums) {
                if (i - num >= 0) {
                    total += dp[i - num];
                }
            }
            dp[i] = total;
        }
        return dp[dp.length - 1];
    }
}