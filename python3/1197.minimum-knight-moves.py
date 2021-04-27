from functools import lru_cache

START_POINTS = {
    (0, 1): 3,
    (1, 0): 3,
    (1, 1): 2,
    (0, 2): 2,
    (2, 0): 2,
    (0, 0): 0
}

class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        
        @lru_cache(None)
        def dfs(x, y):
            if (x, y) in START_POINTS:
                return START_POINTS[x, y]
            return min(dfs(abs(x - 2), abs(y - 1)), dfs(abs(x - 1), abs(y - 2))) + 1
            
        return dfs(abs(x), abs(y))
        
