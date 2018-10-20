class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (!set.contains(nums[i] - 1)) {
                int currNum = nums[i];
                int curr = 0;
                while (set.contains(currNum + 1)) {
                    curr++;
                    currNum++;
                }
                curr++;
                if (result < curr) {
                    result = curr;
                }
            }
        }
        return result;
    }
}