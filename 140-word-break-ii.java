class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, dict, memo);
    }
    private List<String> dfs(String str, int start, Set<String> dict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        List<String> result = new ArrayList<>();
        if (start >= str.length()) {
            result.add("");
            return result;
        }
        for (int end = start + 1; end <= str.length(); end++) {
            String subStr = str.substring(start, end);
            if (dict.contains(subStr)) {
                List<String> nextStrs = dfs(str, end, dict, memo);
                for (String nextStr : nextStrs) {
                    result.add(subStr + (nextStr.equals("") ? "" : " ") + nextStr);
                }
            }
        }
        memo.put(start, result);
        return result;
    }
}