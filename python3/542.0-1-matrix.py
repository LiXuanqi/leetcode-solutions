DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n, m = len(mat), len(mat[0])
        
        ans = [[0] * m for _ in range(n)]
        
        queue = collections.deque()
        visited = set()
        
        for x in range(n):
            for y in range(m):
                if mat[x][y] == 0:
                    point = (x, y)
                    queue.append(point)
                    visited.add(point)
                    
        distance = 0            
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                curr_x, curr_y = curr
                ans[curr_x][curr_y] = distance
                
                for diff_x, diff_y in DIRECTIONS:
                    next_x = diff_x + curr_x
                    next_y = diff_y + curr_y
                    next_point = (next_x, next_y)
                    if in_bound(next_x, next_y, n, m) and next_point not in visited:
                        queue.append(next_point)
                        visited.add(next_point)
                
            distance += 1
        
        return ans
    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
        
