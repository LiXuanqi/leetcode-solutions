class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:
        
        @functools.lru_cache(2000)
        def dfs(nums_left, nums_right, multipliers_index):
            if multipliers_index == len(multipliers):
                return 0
            multiplier = multipliers[multipliers_index]
            take_left = nums[nums_left] * multiplier + dfs(nums_left + 1, nums_right, multipliers_index + 1)
            take_right = nums[nums_right] * multiplier + dfs(nums_left, nums_right - 1, multipliers_index + 1)
            return max(take_left, take_right)
        
        return dfs(0, len(nums) - 1, 0)
        
  
