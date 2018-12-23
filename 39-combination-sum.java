class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int[] nums, int start, int target, List<Integer> temp, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i, target - nums[i], temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}