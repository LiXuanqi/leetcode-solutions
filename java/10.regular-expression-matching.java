class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    continue;
                }
                if (i == 0) {
                    if (p.charAt(j - 1) == '*') {
                        if (j - 2 < 0) { // p = '*'
                            return false;
                        }
                        dp[i][j] = dp[i][j - 2];
                    }
                    continue;
                }
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (p.charAt(j - 1) == '*') {
                    // 0
                    dp[i][j] = dp[i][j - 2];
                    // 1 or 1 or multi
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}