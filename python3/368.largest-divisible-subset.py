class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        n = len(nums)
        dp = [[nums[i]] for i in range(n)]
        
        ans = [nums[0]]
        
        for i in range(1, n):
            curr_max = []
            for j in range(i):
                if nums[i] % nums[j] == 0 and len(dp[j]) > len(curr_max):
                    curr_max = dp[j].copy()
                
            dp[i] = curr_max + [nums[i]]
            # print(dp[i])
            if len(ans) < len(dp[i]):
                ans = dp[i]
            
        return ans
        
