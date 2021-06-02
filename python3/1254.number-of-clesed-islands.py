DIRECTIONS = (
    (0, 1),
    (1, 0),
    (0, -1),
    (-1, 0)
)
class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        
        def mark_visited(curr_x, curr_y):
            grid[curr_x][curr_y] = 1
            for diff_x, diff_y in DIRECTIONS:
                next_x = curr_x + diff_x
                next_y = curr_y + diff_y
                if in_bound(next_x, next_y, n, m) and grid[next_x][next_y] == 0:
                    mark_visited(next_x, next_y)
                    
        for x in range(n):
            for y in range(m):
                if (x == 0 or x == n - 1 or y == 0 or y == m - 1) and grid[x][y] == 0:
                    mark_visited(x, y)
        ans = 0           
        for x in range(n):
            for y in range(m):
                if grid[x][y] == 0:
                    mark_visited(x, y)
                    ans += 1
                    
        return ans
    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
