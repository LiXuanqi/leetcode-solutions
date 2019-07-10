class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        
        self.ans = 0
        
        visited = set()
        row, col = len(grid), len(grid[0])
        empty = 1
        start = (-1, -1)
        end = (-1, -1)
        for x in range(row):
            for y in range(col):
                if grid[x][y] == 1:
                    start = (x, y)
                elif grid[x][y] == 2:
                    end = (x, y)
                elif grid[x][y] == 0:
                    empty += 1
        
        def inBound(x, y):
            return 0 <= x < row and 0 <= y < col
        
        def dfs(x, y, empty):
            
            if (x, y) == end and empty == 0:
                self.ans += 1
            for nextX, nextY in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)):
                if inBound(nextX, nextY) and (nextX, nextY) not in visited and grid[nextX][nextY] != -1:
                    visited.add((nextX, nextY))
                    dfs(nextX, nextY, empty - 1)
                    visited.remove((nextX, nextY))
        visited.add(start);
        dfs(start[0], start[1], empty)
        return self.ans