DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        n, m = len(grid), len(grid[0])
        
        end_point = (n - 1, m - 1)
        
        queue = collections.deque()
        visited = {
            (0, 0): 0
        }
        
      
        queue.append(((0, 0), 0))
        
        ans = 0
        
        while queue:
            for _ in range(len(queue)):
                curr_point, curr_skip = queue.popleft()
                curr_x, curr_y = curr_point
                if curr_point == end_point:
                    return ans
                
                for diff_x, diff_y in DIRECTIONS:
                    next_x = curr_x + diff_x
                    next_y = curr_y + diff_y
                    
                    
                    
                    next_point = (next_x, next_y)
                    
                    if not in_bound(next_x, next_y, n, m):
                        continue
                    
                    next_skip = curr_skip + grid[next_x][next_y]
                    
                    if(
                        next_point in visited and
                        visited[next_point] <= next_skip
                    ):
                        continue
                        
                    if next_skip > k:
                        continue
                        
                    queue.append(((next_point), next_skip))
                    visited[next_point] = next_skip
            ans += 1
                    
        return -1
                        
        
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
                    
