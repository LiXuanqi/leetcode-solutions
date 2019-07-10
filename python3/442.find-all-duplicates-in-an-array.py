class Solution:
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for num in nums:
            num = abs(num)
            if nums[num - 1] < 0:
                ans.append(num)
            else :
                nums[num - 1] *= -1
        return ans