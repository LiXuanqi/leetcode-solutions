class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}
        for i, value in enumerate(nums):
            wanted = target - value
            if wanted in map:
                return [map[wanted], i]
            else:
                map[value] = i
        return None
