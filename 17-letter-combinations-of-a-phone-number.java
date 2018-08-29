class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
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
        dfs(digits, 0, map, results, new StringBuilder());
        return results;
    }
    private void dfs(String digits, int level, Map<Character, String> map, List<String> solutions, StringBuilder sb) {
        if (level >= digits.length()) {
            solutions.add(sb.toString());
            return;
        }
        if (digits.charAt(level) == '1' || digits.charAt(level) == '0') {
            dfs(digits, level + 1, map, solutions, sb);
            return;
        }
        for (char c : map.get(digits.charAt(level)).toCharArray()) {
            sb.append(c);
            dfs(digits, level + 1, map, solutions, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}