from collections import deque, namedtuple
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        Point = namedtuple('Point', 'x, y, step')
        queue = deque()
        
        def neighbors(x, y):
            directions = zip([1, -1, 0, 0], [0, 0, 1, -1])
            for diffX, diffY in directions:
                nextX = x + diffX
                nextY = y + diffY
                if isValid(nextX, nextY, grid):
                    yield nextX, nextY
        
        for i, row in enumerate(grid):
            for j, val in enumerate(row):
                if val == 2:
                    queue.append(Point(i, j, 0))
        ans = 0
        while queue:
            currX, currY, step = queue.popleft()
            ans = max(ans, step)
            for nextX, nextY in neighbors(currX, currY):
                if grid[nextX][nextY] == 1:
                    grid[nextX][nextY] = 2
                    queue.append(Point(nextX, nextY, step + 1))
        
        if any([1 in row for row in grid]):
            return -1
        return ans

def isValid(x, y, grid):
    return 0 <= x < len(grid) and 0 <= y < len(grid[0])