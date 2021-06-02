DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        memo = [[0] * m for _ in range(n)]
        
        def dfs(curr_x, curr_y):
            if memo[curr_x][curr_y] != 0:
                return memo[curr_x][curr_y]
            max_length = 0
            for diff_x, diff_y in DIRECTIONS:
                next_x = curr_x + diff_x
                next_y = curr_y + diff_y
                if in_bound(next_x, next_y, n, m) and matrix[next_x][next_y] > matrix[curr_x][curr_y]:
                    max_length = max(max_length, dfs(next_x, next_y))
            
            ans = max_length + 1
            memo[curr_x][curr_y] = ans
            return ans
        
        ans = 1
        
        for x in range(n):
            for y in range(m):
                ans = max(ans, dfs(x, y))
                
        return ans
    
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
