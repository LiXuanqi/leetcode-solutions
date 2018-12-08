class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        dfs(n, new StringBuilder(), 0, 0, list);
        return list;
    }
    private void dfs(int n, StringBuilder sb, int left, int right, List<String> result) {
        if (left + right == n * 2) {
            if (left == right) {
                result.add(sb.toString());
            }
            return;
        }
        if (left < right) {
            return;
        }
        sb.append('(');
        dfs(n, sb, left + 1, right, result);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        dfs(n, sb, left, right + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}