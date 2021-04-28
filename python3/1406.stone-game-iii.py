TAKE_LIMIT = 3

FIRST = 0
NOT_FIRST = 1

import numpy as np

class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        
        n = len(stoneValue)
        
        dp = np.zeros((n, 2))
        
        for i in range(n - 1, -1, -1):
            curr_max = -np.inf
            for take_num in range(1, TAKE_LIMIT + 1):
                if i + take_num > n:
                    continue
                val = sum(stoneValue[i:i + take_num]) + (dp[i + take_num][NOT_FIRST] if i + take_num < n else 0)
                if val > curr_max:
                    curr_max = val
                    dp[i][FIRST] = val
                    dp[i][NOT_FIRST] = (dp[i + take_num][FIRST]  if i + take_num < n else 0)
                    
        
        if dp[0][FIRST] > dp[0][NOT_FIRST]:
            return 'Alice'
        elif dp[0][FIRST] < dp[0][NOT_FIRST]:
            return 'Bob'
        return 'Tie'
                
