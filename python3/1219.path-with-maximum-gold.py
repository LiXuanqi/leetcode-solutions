DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        
        ans = 0
        
        def dfs(x, y, visited):
            gold = grid[x][y]
            
            max_gain = 0
            for diff_x, diff_y in DIRECTIONS:
                next_x = x + diff_x
                next_y = y + diff_y
                if in_bound(next_x, next_y, n, m) and (next_x, next_y) not in visited and grid[next_x][next_y] != 0:
                    visited.add((next_x, next_y))
                    max_gain = max(dfs(next_x, next_y, visited), max_gain)
                    visited.remove((next_x, next_y))
                    
            return gold + max_gain
            
        
        for x in range(n):
            for y in range(m):
                if grid[x][y] != 0:
                    visited = set()
                    visited.add((x, y))

                    ans = max(ans, dfs(x, y, visited))
                
        return ans
    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
        
        
