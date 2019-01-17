class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int want = target - nums[i];
            if (map.containsKey(want)) {
                return new int[] {map.get(want), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}