class Solution:
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for num in nums:
            num = abs(num)
            if nums[num - 1] > 0:
                nums[num - 1] *= -1
        return [index + 1 for index, value in enumerate(nums) if value > 0]