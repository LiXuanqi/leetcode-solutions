class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        dfs(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }
    private void dfs(int n, int left, int right, StringBuilder sb, List<String> ans) {
        if (left + right == n * 2) {
            if (left == right) {
                ans.add(sb.toString());
            }
            return;
        }
        if (left < right) {
            return;
        }
        sb.append('(');
        dfs(n, left + 1, right, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append(')');
        dfs(n, left, right + 1, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
    }
}