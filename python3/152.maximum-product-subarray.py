MAX = 0
MIN = 1
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        dp = [[1] * 2 for _ in range(len(nums) + 1)]
        
        ans = float('-inf')
        for i in range(len(nums)):
            num = nums[i]
            if num < 0:
                dp[i + 1][MAX] = max(dp[i][MIN] * num, num)
                dp[i + 1][MIN] = min(dp[i][MAX] * num, num)
            elif num > 0:
                dp[i + 1][MAX] = max(dp[i][MAX] * num, num)
                dp[i + 1][MIN] = min(dp[i][MIN] * num, num)
            else:
                dp[i + 1][MAX] = 0
                dp[i + 1][MIN] = 0
                
                
            ans = max(ans, dp[i + 1][MAX])
            
        return ans
        
