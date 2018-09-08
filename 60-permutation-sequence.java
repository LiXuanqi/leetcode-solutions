class Solution {
    String result;
    int count = 0;
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        dfs(new boolean[n], k, sb, n);
        return result;
    }
    private void dfs(boolean[] used, int k, StringBuilder sb, int n) {
        if (sb.length() == n) {
            count++;
            if (k == count) {
                result = sb.toString();
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i - 1]) {
                continue;
            }
            sb.append(i);
            used[i - 1] = true;
            dfs(used, k, sb, n);
            sb.deleteCharAt(sb.length() - 1);
            used[i - 1] = false;             
        }
    }
}