class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return []
        row = len(matrix)
        col = len(matrix[0])
        reach = [[0] * col for _ in matrix]
        # 0 - none
        # 1 - pacific
        # 2 - atlantic
        # 3 - both
        
        directionX = (0, 0, 1, -1)
        directionY = (1, -1, 0, 0)
                  
        def inBound(x, y):
            return 0 <= x < row and 0 <= y < col
        
        def dfs(x, y, flag):
            if reach[x][y] == flag or reach[x][y] == 3:
                return
            reach[x][y] |= flag
            for diffX, diffY in zip(directionX, directionY):
                nextX = x + diffX
                nextY = y + diffY
                if inBound(nextX, nextY) and reach[nextX][nextY] != flag and matrix[nextX][nextY] >= matrix[x][y]:
                    dfs(nextX, nextY, flag)
        
        for x in range(row):
            for y in range(col):
                if x == 0 or y == 0:
                    dfs(x, y, 1)
                if x == row - 1 or y == col - 1:
                    dfs(x, y, 2)
                    
       
        ans = []   
        for x in range(row):
            for y in range(col):
                if reach[x][y] == 3:
                    ans.append([x, y])
        return ans