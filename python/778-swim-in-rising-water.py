class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        
        def inBound(x, y):    
            return 0 <= x < n and 0 <= y < n
        
        def canReach(height):
            if grid[0][0] > height:
                return False
            seen = {(0, 0)}
            queue = collections.deque()
            queue.append((0, 0))
            while queue:
                x, y = queue.popleft()
                if x == n - 1 and y == n - 1:
                    return True
                for nextX, nextY in ((x + 1, y), (x - 1, y), (x, y - 1), (x, y + 1)):
                    if inBound(nextX, nextY) and (nextX, nextY) not in seen and grid[nextX][nextY] <= height:
                        queue.append((nextX, nextY))
                        seen.add((nextX, nextY))
            return False;
            
        n = len(grid)
        left = 0
        right = max(max(row) for row in grid)
        
        
        
        while left + 1 < right:
            mid = (left + right) // 2
            if canReach(mid):
                right = mid
            else:
                left = mid
        if canReach(left):
            return left
        if canReach(right):
            return right
        return -1
    
            
            
            
        
            