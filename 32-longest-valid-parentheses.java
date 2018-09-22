class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int longest = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == ')') {
                    // "))"
                    int leftParenthese = i - dp[i - 1] - 1;
                    if (leftParenthese >= 0 && s.charAt(leftParenthese) == '(') {
                        dp[i] = 2 + ((leftParenthese - 1 >= 0) ? dp[leftParenthese - 1] : 0) + dp[i - 1];
                    } else {
                        dp[i] = 0;
                    }
                } else {
                    // "()"
                    dp[i] = (i - 2 >= 0) ? dp[i - 2] + 2 : 2;
                }
            }  
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}