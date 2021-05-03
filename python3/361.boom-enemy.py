
# Solution 1:
import numpy as np

LEFT = 0
UP = 1
RIGHT = 2
DOWN = 3

class Solution:
    def maxKilledEnemies(self, grid: List[List[str]]) -> int:
        n, m = len(grid), len(grid[0])
        dp = np.zeros((n, m, 4), dtype='int')
        
        direction = LEFT
        for x in range(n):
            for y in range(0, m):
                val = grid[x][y]
                if val == 'W':
                    dp[x][y][direction] = 0
                else:
                    dp[x][y][direction] = dp[x][max(y - 1, 0)][direction] + (1 if val == 'E' else 0)
        
        direction = RIGHT
        for x in range(n):
            for y in range(m - 1, -1 , -1):
                val = grid[x][y]
                if val == 'W':
                    dp[x][y][direction] = 0
                else:
                    dp[x][y][direction] = dp[x][min(y + 1, m - 1)][direction] + (1 if val == 'E' else 0)
        
        direction = UP
        for y in range(m):
            for x in range(0, n):
                val = grid[x][y]
                if val == 'W':
                    dp[x][y][direction] = 0
                else:
                    dp[x][y][direction] = dp[max(x - 1, 0)][y][direction] + (1 if val == 'E' else 0)
                    
        direction = DOWN
        for y in range(m):
            for x in range(n - 1, -1, -1):
                val = grid[x][y]
                if val == 'W':
                    dp[x][y][direction] = 0
                else:
                    dp[x][y][direction] = dp[min(x + 1, n - 1)][y][direction] + (1 if val == 'E' else 0)
        
        ans = 0
        
        for x in range(n):
            for y in range(m):
                if grid[x][y] == '0':
                    ans = max(ans, boom(dp, x, y))
        return ans
    
def boom(dp, x, y):
    return sum(dp[x][y])
 
# Solution 2:
class Solution:
    def maxKilledEnemies(self, grid: List[List[str]]) -> int:
        n, m = len(grid), len(grid[0])
        col_hits = [0] * m
        row_hits = 0
        
        ans = 0
        
        for x in range(n):
            for y in range(m):
                if y == 0 or grid[x][y - 1] == 'W':
                    row_hits = 0
                    
                    k = y
                    while k < m and grid[x][k] != 'W':
                        if grid[x][k] == 'E':
                            row_hits += 1
                        k += 1
                        
                    
                            
                if x == 0 or grid[x - 1][y] == 'W':
                    col_hits[y] = 0
                    
                    k = x
                    while k < n and grid[k][y] != 'W':
                        
                        if grid[k][y] == 'E':
                            col_hits[y] += 1
                        k += 1

                # print(row_hits, col_hits[y])
                if grid[x][y] == '0':
                    ans = max(ans, row_hits + col_hits[y])
        return ans
        

# Brute force: m * n * max(m, n)
# dp: m * n 
