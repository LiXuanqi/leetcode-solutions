import numpy as np
class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        n, m = len(s1), len(s2)
        if n + m != len(s3):
            return False
        dp = np.zeros((n+1, m+1), dtype=bool)
        dp[0][0] = True
        for i in range(1, n+1):
            dp[i][0] = s1[i-1] == s3[i-1] and dp[i-1][0]
        for j in range(1, m+1):
            dp[0][j] = s2[j-1] == s3[j-1] and dp[0][j-1]
        for i in range(1, n+1):
            for j in range(1, m+1):
                s3_index = i + j - 1
                if s3[s3_index] == s1[i-1]:
                    dp[i][j] = dp[i][j] or dp[i-1][j]
                if s3[s3_index] == s2[j-1]:
                    dp[i][j] = dp[i][j] or dp[i][j-1]
        # print(dp)
        return dp[-1][-1]
        
