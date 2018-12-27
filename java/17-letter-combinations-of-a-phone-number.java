class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(map, digits, 0, new StringBuilder(), ans);
        return ans;
    }
    private void dfs(Map<Character, String> map, String digits, int index, StringBuilder sb, List<String> ans) {
        if (index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        if (map.containsKey(c)) {
            String str = map.get(c);
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                dfs(map, digits, index + 1, sb, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            dfs(map, digits, index + 1, sb, ans);
        }
    }
}