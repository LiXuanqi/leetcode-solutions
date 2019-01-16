class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] dpLeft = new int[nums.length + 2];
        int[] dpRight = new int[nums.length + 2];
        dpLeft[0] = 1;
        dpRight[dpRight.length - 1] = 1;
        for (int i = 1; i < dpLeft.length - 1; i++) {
            dpLeft[i] = dpLeft[i - 1] * nums[i - 1];
            dpRight[dpRight.length - 1 - i] = dpRight[dpRight.length - i] * nums[nums.length - i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = dpLeft[i] * dpRight[i + 2];
        }
        return ans;
    }
    // # 1  2  3  4  #
    // 1 1  2  6  24 #
    // # 24 24 12 4  1
}