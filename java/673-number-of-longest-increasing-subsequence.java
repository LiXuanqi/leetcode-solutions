class Solution {
    class Pair {
        int length;
        int times;
        public Pair(int length, int times) {
            this.length = length;
            this.times = times;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Pair[] dp = new Pair[nums.length];
  
        int LIS = 0;
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            int times = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                if (dp[j].length > max) {
                    max = dp[j].length;
                    times = dp[j].times;
                } else if (dp[j].length == max) {
                    times += dp[j].times;
                } 
            }
            dp[i] = new Pair(max + 1, times);
            if (max + 1 > LIS) {
                LIS = max + 1;
            }
        }
        System.out.println(LIS);
        int count = 0;
        for (Pair pair : dp) {
            // System.out.println(pair.length);
            // System.out.println(pair.times);
            if (pair.length == LIS) {
                count += pair.times;
            }
        }
        return count;
    }
}