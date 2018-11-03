class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        char[] str = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            if (isValid(str[i - 1] + "")) {
                sum += dp[i - 1];
            }
            if (i >= 2 && isValid(str[i - 2] + "" + str[i - 1])) {         
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
        int val = Integer.parseInt(str);
        return 1 <= val && val <= 26;
    }
}

//    "2 2 6"
//  1  1 2 3