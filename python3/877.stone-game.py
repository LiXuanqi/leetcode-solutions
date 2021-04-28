import numpy as np

FIRST = 0
NOT_FIRST = 1

class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)
        dp = np.zeros((n, n, 2))
        
        for i in range(n):
            dp[i][i][FIRST] = piles[i]
            
    
        
        for left in range(n - 1):
            for length in range(2,):
                right = min(left + length - 1, n - 1)
                
                take_left = piles[left] + dp[left + 1][right][NOT_FIRST]
                take_right = piles[right] + dp[left][right - 1][NOT_FIRST]
                
                if take_left > take_right:
                    dp[left][right][FIRST] = take_left
                    dp[left][right][NOT_FIRST] = dp[left + 1][right][FIRST]
                else:
                    
                    dp[left][right][FIRST] = take_right
                    dp[left][right][NOT_FIRST] = dp[left][right - 1][FIRST]
        
        
        return dp[0][n - 1][FIRST] - dp[0][n - 1][NOT_FIRST] 
        
