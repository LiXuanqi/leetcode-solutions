class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(nums, used, temp, ans);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}