DIRECTIONS = (
    (1, 0),
    (-1, 0),
    (0, 1),
    (0, -1),
    (1, 1),
    (1, -1),
    (-1, 1),
    (-1, -1)
)

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0] or grid[0][0] == 1:
            return -1
        
        n, m = len(grid), len(grid[0])
        
        queue = collections.deque([(0, 0)])
        visited = {(0, 0)}
        
        ans = 1
        
        while queue:
            for _ in range(len(queue)):
                curr_x, curr_y = queue.popleft()
                
                if curr_x == n - 1 and curr_y == m - 1:
                    return ans
                
                for diff_x, diff_y in DIRECTIONS:
                    next_x = curr_x + diff_x
                    next_y = curr_y + diff_y
                    next_point = (next_x, next_y)
                    if (
                        in_bound(next_x, next_y, n, m) 
                        and next_point not in visited
                        and grid[next_x][next_y] == 0
                    ):
                        queue.append(next_point)
                        visited.add(next_point)
                
                
            ans += 1
            
        return -1
    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
