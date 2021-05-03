class Solution:
    def longestArithSeqLength(self, A: List[int]) -> int:
        if not A:
            return 0
        if len(A) == 1:
            return 1
        
        n = len(A)
        dp = [{0: 1} for _ in range(n)] 
        
        
        ans = 0
        
        for second in range(1, n):
            for first in range(second):
                diff = A[second] - A[first]
      
                
                dp[second][diff] = dp[first].get(diff, 1) + 1
                ans = max(ans, dp[second][diff])
                
        return ans
