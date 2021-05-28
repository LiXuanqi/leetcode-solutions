MOD = 10 ** 9 + 7
class Solution:
    def checkRecord(self, n: int) -> int:
        
        dp = [[[0] * 3 for _ in range(2)] for _ in range(n + 1)]
  
        dp[1][0][0] = 1
        dp[1][0][1] = 2
        dp[1][0][2] = 2
        dp[1][1][0] = 2
        dp[1][1][1] = 3
        dp[1][1][2] = 3
  
        for i in range(2, n + 1): 
            for j in range(2):
                for k in range(3):
                    val = 0
                    # Absent
                    if j > 0:
                        val = (val + dp[i - 1][j - 1][2]) % MOD
                    # Present
                    val = (val + dp[i - 1][j][2]) % MOD
               
                    # Late
                    if k > 0:
                        val = (val + dp[i - 1][j][k - 1]) % MOD
                        
                    dp[i][j][k] = val
  
        return dp[n][1][2]
                    
                    
        
