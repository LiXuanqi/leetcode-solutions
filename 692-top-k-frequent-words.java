class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) {
            return ans;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String>[] bukkits = new List[words.length + 1];
        for (String key : map.keySet()) {
            int frequency = map.get(key);
            if (bukkits[frequency] == null) {
                bukkits[frequency] = new ArrayList<>();
            }
            bukkits[frequency].add(key);
        }
        for (int i = bukkits.length - 1; i>= 0; i--) {
            if (k <= 0) {
                break;
            }
            if (bukkits[i] != null) {

                Collections.sort(bukkits[i]);
                for (int j = 0; j < bukkits[i].size(); j++) {
                    if (k <= 0) {
                        break;
                    }
                    ans.add(bukkits[i].get(j));
                    k--;
                }
            }
        }
        return ans;
    }
}