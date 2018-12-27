class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        } 
        dfs(0, n, new ArrayList<>(), new boolean[n]);
        return count;
    }
    private void dfs(int level, int n, List<Integer> temp, boolean[] used) {
        if (level >= n) {
            count++;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            temp.add(i);
            used[i] = true;
            if (isValid(temp)) {
                dfs(level + 1, n, temp, used);   
            }
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
    private boolean isValid(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(list.size() - 1)) == Math.abs(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}