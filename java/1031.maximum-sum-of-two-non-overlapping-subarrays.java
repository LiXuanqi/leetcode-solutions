class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
  
        int[] leftPrefixSum = new int[A.length];
        int[] rightPrefixSum = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count += A[i];
            leftPrefixSum[i] = count;
        }
        count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            count += A[i];
            rightPrefixSum[i] = count;
        }
        int[] leftSumL = getLeftSum(leftPrefixSum, L);
        int[] leftSumM = getLeftSum(leftPrefixSum, M);
        int[] rightSumL = getRightSum(rightPrefixSum, L);
        int[] rightSumM = getRightSum(rightPrefixSum, M);
        int ans = Integer.MIN_VALUE;
   
        for (int i = 0; i < A.length - 1; i++) {
            int sum1 = leftSumL[i] + rightSumM[i + 1];
            int sum2 = leftSumM[i] + rightSumL[i + 1];
            ans = Math.max(ans, Math.max(sum1, sum2));
        }
        return ans;
    }
    private int[] getLeftSum(int[] prefixSum, int L) {
        int[] ans = new int[prefixSum.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            int sum = prefixSum[i] - (i - L >= 0 ? prefixSum[i - L]: 0);
            ans[i] = Math.max(sum, max);
            max = ans[i];
        }
        return ans;
    }
    private int[] getRightSum(int[] prefixSum, int R) {
        int[] ans = new int[prefixSum.length];
        int max = Integer.MIN_VALUE;
        for (int i = ans.length - 1; i >= 0; i--) {
            int sum = prefixSum[i] - (i + R < prefixSum.length ? prefixSum[i + R] : 0);
            ans[i] = Math.max(sum, max);
            max = ans[i];
        }
        return ans;
    }
}