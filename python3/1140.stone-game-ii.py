import numpy as np

FIRST = 0
NOT_FIRST = 1

class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        
        dp = np.zeros((n, n + 1, 2), 'int')
        
        suffix_sum = [0] * (n + 1)
        
        for i in range(n - 1, -1, -1):
            suffix_sum[i] = suffix_sum[i + 1] + piles[i]
            for m in range(n + 1):
                # take rest of all piles
                if i + 2 * m >= n:
                    dp[i][m][FIRST] = suffix_sum[i]
                    dp[i][m][NOT_FIRST] = 0
                else:
                    curr_max = 0
                    for take_num in range(1, 2 * m + 1):
                        if n - i - 1 < take_num:
                            continue
                        val = suffix_sum[i] - suffix_sum[i + take_num]+ dp[i + take_num][max(m, take_num)][NOT_FIRST]
                        if val > curr_max:
                            curr_max = val
                            dp[i][m][FIRST] = val
                            dp[i][m][NOT_FIRST] = dp[i + take_num][max(m, take_num)][FIRST]
      
        return dp[0][1][0]
                
