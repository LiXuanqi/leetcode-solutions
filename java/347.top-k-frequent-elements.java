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
            int frequent = map.get(key);
            if (bukkits[frequent] == null) {
                bukkits[frequent] = new ArrayList<>();
            }
            bukkits[frequent].add(key);
        }
        int count = 0;
        for (int i = bukkits.length - 1; i >= 0; i--) {
            if (count == k) {
                break;
            }
            if (bukkits[i] != null) {
                count += bukkits[i].size();
                ans.addAll(bukkits[i]);
            }
        }
        return ans;
    }
}