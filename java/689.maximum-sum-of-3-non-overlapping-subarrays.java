class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        // prefix sum.
        int[] prefixSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i + 1] = sum;
        }
        // left max
        int[] leftMaxSum = new int[nums.length - 2 * k];
        int leftMax = Integer.MIN_VALUE;
        for (int i = k - 1; i < nums.length - 2 * k; i++) {
            int windowSum = getIntervalSum(prefixSum, i - k + 1, i);
            if (windowSum > leftMax) {
                leftMax = windowSum;
                leftMaxSum[i] = i - k + 1;
            } else {
                leftMaxSum[i] = leftMaxSum[i - 1];
            }
        }
        // right max
        int[] rightMaxSum = new int[nums.length - 2 * k];
        int rightMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 3 * k - 1; i--) {
            int windowSum = getIntervalSum(prefixSum, i - k + 1, i);
            if (windowSum > rightMax) {
                rightMax = windowSum;
                rightMaxSum[i - 3 * k + 1] = i - k + 1;
            } else {
                rightMaxSum[i - 3 * k + 1] = rightMaxSum[i - 3 * k + 2];
            }
        }
        // System.out.println("leftMaxSum");
        // print(leftMaxSum);
        // System.out.println("rightMaxSum");
        // print(rightMaxSum);
        int max = Integer.MIN_VALUE;
        int[] result = new int[3];
        for (int i = k; i < nums.length - 2 * k + 1; i++) {
            int start = i;
            int end = i + k - 1;
            int midSum = getIntervalSum(prefixSum, start, end);
            int leftSumStartIndex = leftMaxSum[start - 1];
            int rightSumStartIndex = rightMaxSum[end + 1 - 2 * k];
            int leftSum = getIntervalSum(prefixSum, leftSumStartIndex, leftSumStartIndex + k - 1);
            int rightSum = getIntervalSum(prefixSum, rightSumStartIndex, rightSumStartIndex + k - 1);
            int total = midSum + leftSum + rightSum;
            if (total > max) {
                max = total;
                result[0] = leftSumStartIndex;
                result[1] = start;
                result[2] = rightSumStartIndex;
            }
        
        }
        return result;
    }
    private int getIntervalSum(int[] prefixSum, int start, int end) {
        return prefixSum[end + 1] - prefixSum[start];
    }
    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
//       0  1  2  3  4  5  6  7
//      [1, 2, 1, 2, 6, 7, 5, 1]
//       2

// left: 0, 0, 0, 4
// right:            4, 5, 6