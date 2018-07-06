class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> solutions) {
        if (temp.size() == nums.length) {
            solutions.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            dfs(nums, used, temp, solutions);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}

// Time = O(n!)
// Space = O(n)(call stack) + O(n)(boolean[] used)