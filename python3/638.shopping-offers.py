class Solution:
    def shoppingOffers(self, price: List[int], specials: List[List[int]], needs: List[int]) -> int:
        
        @functools.lru_cache(None)
        def dfs(needs):
            
            # don't use special offer
            cost = sum( 
                price[i] * needs[i]
                for i in range(len(needs))
            )
            
            for special in specials:
                
                for i in range(len(special) - 1):
                    next_status = tuple(needs[i] - special[i] for i in range(len(needs)))
                if is_valid(next_status):
                    cost = min(cost, dfs(next_status) + special[-1])
                    
            return cost
        
        return dfs(tuple(needs))
                    
def is_valid(needs):
    return min(needs) >= 0
           
        
