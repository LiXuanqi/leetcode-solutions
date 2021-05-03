DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

MARKER = 2

class Solution:
    def shortestBridge(self, A: List[List[int]]) -> int:
        n, m = len(A), len(A[0])
        # find one island first
        island = mark_island(A, MARKER)
        visited = island.copy()
        

        queue = collections.deque(island)
        
        ans = 0
        
        while queue:
            for _ in range(len(queue)):
                curr_x, curr_y = queue.popleft()
                # Reach another island
                
                if A[curr_x][curr_y] == 1:
                    return ans - 1
                for diff_x, diff_y in DIRECTIONS:
                    next_x, next_y = curr_x + diff_x, curr_y + diff_y
                    if in_bound(next_x, next_y, n, m) and A[next_x][next_y] != MARKER and (next_x, next_y) not in visited:
                        queue.append((next_x, next_y))
                        visited.add((next_x, next_y))
            ans += 1
            
                        
        return None
    
def mark_island(matrix, MARKER):
    n, m = len(matrix), len(matrix[0])
    group = set()
    
    def dfs(x, y):
        group.add((x, y))
        matrix[x][y] = MARKER
        
        for diff_x, diff_y in DIRECTIONS:
            next_x, next_y = x + diff_x, y + diff_y
            if in_bound(next_x, next_y, n, m) and matrix[next_x][next_y] == 1:
                dfs(next_x, next_y)
            
    for x in range(n):
        for y in range(m):
            if matrix[x][y] == 1:
                dfs(x, y)
                return group
            
    return None
    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
