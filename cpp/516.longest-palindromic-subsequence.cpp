class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int dp[s.size()][s.size()];
        // initialize dp
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < s.size(); i++) {
            dp[i][i] = 1;
        }
        for (int length = 2; length <= s.size(); length++) {
            for (int startIndex = 0; startIndex < s.size(); startIndex++) {
                int endIndex = startIndex + length - 1;
                if (endIndex >= s.size()) {
                    continue;
                }
                if (s.at(startIndex) == s.at(endIndex)) {
                    dp[startIndex][endIndex] = dp[startIndex + 1][endIndex - 1] + 2;
                } else {
                    dp[startIndex][endIndex] = max(dp[startIndex][endIndex - 1], dp[startIndex + 1][endIndex]);
                } 
            }
        }
        return dp[0][s.size() - 1];
    }
};