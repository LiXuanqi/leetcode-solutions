DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

MOD = 10 ** 9 + 7

class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        dp = [[[0] * (maxMove + 1) for _ in range(n)] for _ in range(m)]
        
        ans = 0
        for move_step in range(1, maxMove + 1):
            for x in range(m):
                for y in range(n):
                    total = 0
                    for diff_x, diff_y in DIRECTIONS:
                        next_x = x + diff_x
                        next_y = y + diff_y
                        if move_step == 1:
                            if not in_bound(next_x, next_y, m, n):
                                total += 1
                        else:
                            if in_bound(next_x, next_y, m, n):
                                total += dp[next_x][next_y][move_step - 1]
                    
                    dp[x][y][move_step] = total % MOD
                    if (x, y) == (startRow, startColumn):
                        ans = (ans + dp[x][y][move_step]) % MOD
                    
        return ans
                    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
                
            
        
