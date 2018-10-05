class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, 0, S, 0);
        return count;
    }
    private void dfs(int[] nums, int level, int S, int sum) {
        if (level == nums.length) {
            if (sum == S) {
                count++;  
            }
            return;
        }
        // add
        dfs(nums, level + 1, S, sum + nums[level]);
        // minus
        dfs(nums, level + 1, S, sum - nums[level]);
    }
}