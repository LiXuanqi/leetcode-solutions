class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;       
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}