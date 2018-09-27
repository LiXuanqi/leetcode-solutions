class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solutions = new ArrayList<>();
        dfs(1, n, k, solutions, new ArrayList<>());
        return solutions;
    }
    private void dfs(int start, int n, int k, List<List<Integer>> solutions, List<Integer> temp) {
        if (temp.size() == k) {
            solutions.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            dfs(i + 1, n, k, solutions, temp);
            temp.remove(temp.size() - 1);
        }
    }
}