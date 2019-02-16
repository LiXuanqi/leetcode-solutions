class Solution:
    def findMissingRanges(self, nums: 'List[int]', lower: 'int', upper: 'int') -> 'List[str]':
        nums.append(upper + 1)
        prev = lower - 1
        ans = []
        for i in nums:
            if i == prev + 2:
                ans.append(str(i - 1))
            elif i > prev + 2:
                ans.append("%d->%d" % (prev + 1, i - 1))
            prev = i
        return ans