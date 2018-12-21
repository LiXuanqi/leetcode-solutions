class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            leftProducts[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            rightProducts[i] = product;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = i > 0 ? leftProducts[i - 1] : 1;
            int right = i < nums.length - 1 ? rightProducts[i + 1] : 1;
            ans[i] = left * right;
        }
        return ans;
    }
    // 1  2  6 24
    // 24 24 12 4
}