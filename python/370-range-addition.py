class Solution:
    def getModifiedArray(self, length: 'int', updates: 'List[List[int]]') -> 'List[int]':
        nums = [0] * length
        if not updates:
            return nums
        for start, end, diff in updates:
            nums[start] += diff
            if end + 1 < len(nums):
                nums[end + 1] -= diff
        for i in range(len(nums)):
            if i > 0:
                nums[i] += nums[i - 1]
        return nums