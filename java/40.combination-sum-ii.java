class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new boolean[candidates.length], new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int[] candidates, int start, int target, boolean[] used, List<Integer> temp, List<List<Integer>> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(temp));
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            used[i] = true;
            dfs(candidates, i + 1, target - candidates[i], used, temp, list);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}