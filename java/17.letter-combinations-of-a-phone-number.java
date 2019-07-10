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
        dfs(digits, 0, new StringBuilder(), ans, map);
        return ans;
    }
    private void dfs(
        String digits,
        int index,
        StringBuilder sb,
        List<String> ans,
        Map<Character, String> map
    ) {
        if (index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        if (map.containsKey(c)) {
            for (char next : map.get(c).toCharArray()) {
                sb.append(next);
                dfs(digits, index + 1, sb, ans, map);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            dfs(digits, index + 1, sb, ans, map);
        }
    }
}