class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> solutions = new ArrayList<>();
        if (n < 0) {
            return solutions;
        }
        if (n == 0) {
            solutions.add("");
            return solutions;
        }
        dfs(new StringBuilder(), 0, 0, n, solutions);
        return solutions;
    }
    private void dfs(
        StringBuilder sb,
        int left,
        int right,
        int n,
        List<String> solutions
    ) {
        if (left + right > 2 * n) {
            return;
        }
        
        if (left == right && left + right == 2 * n) {
            solutions.add(sb.toString());
            return;
        }
        if (left < right) {
            return;
        }
        sb.append('(');
        dfs(sb, left + 1, right, n, solutions);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        dfs(sb, left, right + 1, n, solutions);
        sb.deleteCharAt(sb.length() - 1);
    }
}