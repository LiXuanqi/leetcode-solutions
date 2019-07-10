class Solution:
    def summaryRanges(self, nums: 'List[int]') -> 'List[str]':
        ans = []
        if not nums or len(nums) == 0:
            return ans
        start, end = nums[0], nums[0]
        prev = nums[0] - 1
        for num in nums:
            if prev + 1 != num:
                ans.append(str(start) if start == end else "%d->%d" % (start, end))
                start = num
            end = num
            prev = num
        ans.append(str(start) if start == end else "%d->%d" % (start, end))
        return ans