class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int code = uniCode(str);
            if (map.containsKey(code)) {
                map.get(code).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(code, list);
            }
        }
        for (List<String> list : map.values()) {
            results.add(list);
        }
        return results;
        
    }
    private int uniCode (String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += str.charAt(i) * str.charAt(i) * str.charAt(i) * str.charAt(i);
        }
        return count;
    }
}