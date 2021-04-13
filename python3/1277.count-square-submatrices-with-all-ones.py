import numpy as np
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        dp = np.array(matrix)
           
        for x in range(1, n):
            for y in range(1, m):
                if matrix[x][y] == 1:
                    dp[x][y] = min(dp[x - 1][y], dp[x][y - 1], dp[x - 1][y - 1]) + 1
    
        return sum(sum(dp))
        
        