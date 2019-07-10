class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        maxReach = 0
        for index in range(len(nums)):
            if index <= maxReach:
                maxReach = max(maxReach, index + nums[index])
        return maxReach >= len(nums) - 1