class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String>[] bukkit = new List[words.length];
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (bukkit[frequency] == null) {
                bukkit[frequency] = new ArrayList<>();
            }
            bukkit[frequency].add(entry.getKey());
        }
        int count = 0;
        for (int i = bukkit.length - 1; i >= 0; i--) {
            if (bukkit[i] == null) {
                continue;
            }
            Collections.sort(bukkit[i]);
            for (String str : bukkit[i]) {
                result.add(str);
                count++;
                if (count == k) {
                    
                    return result;
                }
            }
        }
     
        
        return result;
    }
}