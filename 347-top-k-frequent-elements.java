class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List[] bukkits = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            if (bukkits[map.get(key)] == null) {
                bukkits[map.get(key)] = new ArrayList<>();
            }
            bukkits[map.get(key)].add(key);
        }
        for (int i = bukkits.length - 1; i >= 0; i--) {
            if (k <= 0) {
                break;
            }
            if (bukkits[i] != null) {
                ans.addAll(bukkits[i]);
                k -= bukkits[i].size();
            }
        }
        return ans;
    }
}