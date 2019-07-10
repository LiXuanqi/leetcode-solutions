class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k <= 0) {
            return ans;
        }
        dfs(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int k, int target, int start, List<Integer> temp, List<List<Integer>> ans) {
        if (target < 0 || temp.size() > k) {
            return;
        }
        if (target == 0 && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
    
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            dfs(k, target - i, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}