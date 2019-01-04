class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List[] bukkits = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bukkits[freq] == null) {
                bukkits[freq] = new ArrayList<>();
            }
            bukkits[freq].add(key);
        }
        // iterate from tail.
        for (int i = bukkits.length - 1; i >= 0; i--) {
            if (k <= 0) {
                break;
            }
            if (bukkits[i] != null) {
                k -= bukkits[i].size();
                ans.addAll(bukkits[i]);
            }
        }
        return ans;
    }
}