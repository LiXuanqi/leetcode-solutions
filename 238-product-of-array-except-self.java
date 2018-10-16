class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] dpLeft = new int[nums.length + 2];
        int[] dpRight = new int[nums.length + 2];
        dpLeft[0] = 1;
        dpRight[0] = 1;
        dpLeft[dpLeft.length - 1] = 1;
        dpRight[dpRight.length - 1] = 1;
        
        for (int i = 1; i < dpLeft.length - 1; i++) {
            dpLeft[i] = dpLeft[i - 1] * nums[i - 1];
            dpRight[dpRight.length - 1 - i] = dpRight[dpRight.length - i] * nums[nums.length - i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = dpLeft[i] * dpRight[i + 2];
        }
        return result;
    }
}