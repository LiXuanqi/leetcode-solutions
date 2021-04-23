import numpy as np

class Solution:
    def longestLine(self, M: List[List[int]]) -> int:
        
        if not M or not M[0]:
            return 0
        
        n, m = len(M), len(M[0])
        
        # dp[i][j][k]
        # k = 0 horizontal
        # k = 1 vertical
        # k = 2 diagonal
        # k = 3 anti-diagonal
        dp = np.zeros((n, m, 4), 'int')
        
        ans = 0
        
        for x in range(n):
            for y in range(m):
                if x * y == 0:
                    dp[x][y][:] = M[x][y]
                if M[x][y] == 0:
                    dp[x][y][:] = 0
                else:
                    if y > 0:
                        dp[x][y][0] = dp[x][y - 1][0] + 1
                    if x > 0:
                        dp[x][y][1] = dp[x - 1][y][1] + 1 
                    if x > 0 and y > 0:
                        dp[x][y][2] = dp[x - 1][y - 1][2] + 1
                    if x > 0 and y < m - 1:
                        dp[x][y][3] = dp[x - 1][y + 1][3] + 1
                
                ans = max(ans, max(dp[x][y][:])) 
                
        
        
        return ans
