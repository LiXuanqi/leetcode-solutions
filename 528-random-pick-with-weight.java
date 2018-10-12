class Solution {
    int[] prefixSum;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }
    
    public int pickIndex() {
        // generate random.
        Random random = new Random();
        int randomNumber = random.nextInt(prefixSum[prefixSum.length - 1]);
        return findLarger(prefixSum, randomNumber);
    }
    private int findLarger(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        if (nums.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > target) {
            return left;
        }
        if (nums[right] > target) {
            return right;
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */