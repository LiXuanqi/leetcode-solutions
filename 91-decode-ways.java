class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {     
            int sum = 0;
            // check 1 position.
            if (isValid(s.substring(s.length() - i, s.length() - i + 1))) {
                sum += dp[i - 1];
            }
            // check 2 position.
            if (i >= 2 && isValid(s.substring(s.length() - i, s.length() - i + 2))) {
                sum += dp[i - 2];
            }
            dp[i] = sum;
        }
        return dp[dp.length - 1];
    }
    private boolean isValid(String str) {
        if (str.startsWith("0")) {
            return false;
        }
        int num = Integer.parseInt(str);
        return 1 <= num && num <= 26;
    }
}