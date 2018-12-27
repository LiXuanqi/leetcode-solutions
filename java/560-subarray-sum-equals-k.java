class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // System.out.println(map);
        }
        return count;
    }
}