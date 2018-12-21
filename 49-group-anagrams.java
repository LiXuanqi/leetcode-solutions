class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] aux = str.toCharArray();
            Arrays.sort(aux);
            String word  = String.valueOf(aux);
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(str);
        }
        return new ArrayList<>(map.values());
    }
}