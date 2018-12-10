class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        // Arrays.fill(triangle, Integer.MAX_VALUE);
        for (List<Integer> level : triangle) {
            for (int i = level.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    dp[i] = dp[i] + level.get(i);
                } else if (i == level.size() - 1) {
                    dp[i] = dp[i - 1] + level.get(i);                   
                } else {
                    dp[i] = Math.min(dp[i - 1], dp[i]) + level.get(i);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.min(dp[i], ans);
        }
        return ans;
    }

}