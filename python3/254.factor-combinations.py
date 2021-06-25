class Solution:
    @functools.lru_cache(None)
    def getFactors(self, n: int) -> List[List[int]]:
        ans = []
        
        factor = 2
        while factor * factor <= n:
            if n % factor == 0:
                ans.append([factor, n // factor])
                for factors in self.getFactors(n // factor):

                    if factor <= factors[0]:
                        ans.append([factor] + factors)
            factor += 1
            
        return ans
                
        
