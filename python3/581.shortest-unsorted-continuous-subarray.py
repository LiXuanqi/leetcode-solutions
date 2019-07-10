class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        standard = sorted(nums)
        left = 0
        right = len(nums) - 1
        while left <= right and nums[left] == standard[left]:
            left += 1
        while left <= right and nums[right] == standard[right]:
            right -= 1
        return right - left + 1 if left < right else 0