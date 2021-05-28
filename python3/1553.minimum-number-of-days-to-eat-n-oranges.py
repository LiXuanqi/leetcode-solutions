class Solution:
    def minDays(self, n: int) -> int:
        
        @functools.lru_cache(None)
        def dfs(curr):
            if curr <= 1:
                return curr
            
            return min(curr % 2 + dfs(curr // 2), curr % 3 + dfs(curr // 3)) + 1
            
        return dfs(n)
            
