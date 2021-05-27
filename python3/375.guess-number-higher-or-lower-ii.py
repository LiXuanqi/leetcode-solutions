class Solution:
    def getMoneyAmount(self, n: int) -> int:
        
        @functools.lru_cache(None)
        def dfs(left, right):
            if left >= right:
                return 0
            min_cost = float('inf')
            for guess in range(left, right + 1):
                
                # max - because I will know in which part.
                cost = guess + max(dfs(left, guess - 1), dfs(guess + 1, right))
                min_cost = min(min_cost, cost)
            return min_cost
        
        return dfs(1, n)
                
            
        
