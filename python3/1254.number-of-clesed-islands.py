DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        # Fill the bound lands.
        for i in range(n):
            if grid[i][0] == 0:
                mark_connected_lands_as_visited(i, 0, grid)
            if grid[i][m - 1] == 0:
                mark_connected_lands_as_visited(i, m - 1, grid)
        for i in range(m):
            if grid[0][i] == 0:
                mark_connected_lands_as_visited(0, i, grid)
            if grid[n - 1][i] == 0:
                mark_connected_lands_as_visited(n - 1, i, grid)
        
        ans = 0
        for x in range(1, n - 1):
            for y in range(1, m - 1):
                if grid[x][y] == 0:
                    mark_connected_lands_as_visited(x, y, grid)
                    ans += 1
        return ans
        
def mark_connected_lands_as_visited(x, y, grid):
    queue = collections.deque()
    queue.append((x, y))
    while queue:
        curr_x, curr_y = queue.popleft()
        for diff_x, diff_y in DIRECTIONS:
            next_x, next_y = curr_x + diff_x, curr_y + diff_y
            if in_bound(next_x, next_y, grid) and grid[next_x][next_y] == 0:
                queue.append((next_x, next_y))
                grid[next_x][next_y] = 1
    
def in_bound(x, y, grid):
    return 0 <= x < len(grid) and 0 <= y < len(grid[0])