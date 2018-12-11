class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] copy = str.toCharArray();
            Arrays.sort(copy);
            String sorted = String.valueOf(copy);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
}