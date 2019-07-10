class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int zero = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[left++] == 0) {
                    zero--;
                }
            }
            int length = right - left + 1;
            ans = Math.max(ans, length);
        }
        return ans;
    }
}