class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        
        def inBound(x, y):    
            return 0 <= x < n and 0 <= y < n
        
        n = len(grid)
        Point = collections.namedtuple('Point', 'cost, x, y')
        seen = set()
        pq = []
        heapq.heappush(pq, Point(grid[0][0], 0, 0))
        seen.add((0, 0))
        while pq:
            cost, x, y = heapq.heappop(pq)
            if x == n - 1 and y == n - 1:
                return cost
            # 4 directions
            for nextX, nextY in ((x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1)):
                if inBound(nextX, nextY) and (nextX, nextY) not in seen:
                    heapq.heappush(pq, Point(max(cost, grid[nextX][nextY]), nextX, nextY))
                    seen.add((nextX, nextY))
        return -1
            
            
        
            