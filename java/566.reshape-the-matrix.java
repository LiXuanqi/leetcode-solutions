class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] ans = new int[r][c];
        int count = 0;
        for (int[] row : nums) {
            for (int num : row) {
                ans[count / c][count % c] = num;
                count++;
            }
        }
        return ans;
    }
}