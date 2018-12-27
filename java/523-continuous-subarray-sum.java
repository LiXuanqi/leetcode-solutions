class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(); 
        map.put(0, -1);
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum) && i - map.get(sum) >= 2) {
                return true;
            }
            map.put(sum, map.containsKey(sum) ? Math.min(map.get(sum), i) : i);
        }
        return false;
    }
}