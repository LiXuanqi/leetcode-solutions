class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if (S == null || S.length() == 0) {
            ans.add("");
            return ans;
        }
        dfs(S, 0, new StringBuilder(), ans);
        return ans;
    }
    private void dfs(String S, int index, StringBuilder sb, List<String> ans) {
        if (index >= S.length()) {
            if (sb.length() == S.length()) {
                ans.add(sb.toString());
            }
            return;
        }
        if (Character.isLetter(S.charAt(index))) {
            sb.append(Character.toUpperCase(S.charAt(index)));
            dfs(S, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toLowerCase(S.charAt(index)));
            dfs(S, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(S.charAt(index));
            dfs(S, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}