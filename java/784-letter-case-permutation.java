class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if (S == null) {
            return ans;
        }
        dfs(S, 0, new StringBuilder(), ans);
        return ans;
    }
    private void dfs(String str, int index, StringBuilder sb, List<String> ans) {
        if (index >= str.length()) {
            ans.add(sb.toString());
            return;
        }
        char c = str.charAt(index);
        if (Character.isLetter(c)) {
            sb.append(Character.toUpperCase(c));
            dfs(str, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);       
            sb.append(Character.toLowerCase(c));
            dfs(str, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(c);
            dfs(str, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}