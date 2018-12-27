class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if (map.containsKey(target)) {
                int start = map.get(target).get(0);
                int max = i - start;
                if (max > maxLength) {
                    maxLength = max;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }
        return maxLength;
    }
}