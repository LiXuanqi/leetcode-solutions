// Solution1: dp
class Solution {
    public int subarrayBitwiseORs(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length][A.length + 1];
        // init 
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A.length + 1; j++) {
                if (i + j - 1 < A.length) {
                    dp[i][j] = dp[i][j - 1] | A[i + j - 1]; 
                    set.add(dp[i][j]);
                }
            }
        }
        return set.size();
    }
}
// Time = O(n^2)
// Space = O(n^2)