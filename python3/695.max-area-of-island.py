DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        
        
        ans = 0
        
        def flood(x, y):
            grid[x][y] = 0
            area = 1
            for diff_x, diff_y in DIRECTIONS:
                next_x = x + diff_x
                next_y = y + diff_y
                if in_bound(next_x, next_y, n, m) and grid[next_x][next_y] == 1:
                    area += flood(next_x, next_y)
            return area
            
        
        for x in range(n):
            for y in range(m):
                if grid[x][y] == 1:
                    ans = max(ans, flood(x, y))
        return ans
    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
