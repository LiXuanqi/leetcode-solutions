class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(
        int[] nums,
        boolean[] visited,
        List<Integer> temp,
        List<List<Integer>> ans
    ) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, temp, ans);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}