class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // System.out.println(map);
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }
        
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (result.size() >= k) {
                break;
            }
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    // System.out.println(num);
                    if (result.size() >= k) {
                        break;
                    }
                    result.add(num);
                }
            }
        }
        return result;
    }
}