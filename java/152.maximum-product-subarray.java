class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = 1;
        int max = 1;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(num, max * num);
            min = Math.min(num, min * num);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}