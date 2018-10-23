class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int longest = 0;
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        dp[0] = 0;
        // dp[i] 
        for (int i = 1; i < str.length; i++) {
            if (str[i] == '(') {
                dp[i] = 0;
            } else {
                // ()
                if (str[i - 1] == '(') {
       
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    // ))
                    int mostLeftParentheseIndex = i - dp[i - 1] - 1;
                    if (mostLeftParentheseIndex >= 0 && str[mostLeftParentheseIndex] == '(') {
                        dp[i] = 2 + dp[i - 1] + (mostLeftParentheseIndex >= 1 ? dp[mostLeftParentheseIndex - 1] : 0);
                    }
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}

