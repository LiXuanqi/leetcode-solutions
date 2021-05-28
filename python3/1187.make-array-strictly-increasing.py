class Solution:
    def makeArrayIncreasing(self, arr1: List[int], arr2: List[int]) -> int:
        arr2.sort()
        
        n = len(arr1)
        m = len(arr2)
        
        dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]
        
        dp[0][0] = float('-inf')
        
        
        for i in range(1, n + 1):
            for j in range(m + 1):
             
                # not replace
            
                if arr1[i - 1] > dp[i - 1][j]:
                    dp[i][j] = min(arr1[i - 1], dp[i][j])
                # replace
                if j > 0:
                    replace_index = bisect.bisect_right(arr2, dp[i - 1][j - 1])
                    if replace_index < len(arr2):
                   
                        dp[i][j] = min(dp[i][j], arr2[replace_index])


        for j in range(m + 1):
            if dp[n][j] != float('inf'):
                return j
            
        return -1
            
                    
                
        
        
