class Solution:
    def thirdMax(self, nums: 'List[int]') -> 'int':
        maxNums = [float('-inf'), float('-inf'), float('-inf')]
        for num in nums:
            if num not in maxNums:
                if num > maxNums[0]:
                    maxNums = [num, maxNums[0], maxNums[1]]
                elif num > maxNums[1]:
                    maxNums = [maxNums[0], num, maxNums[1]]
                elif num > maxNums[2]:
                    maxNums = [maxNums[0], maxNums[1], num]
        return max(maxNums) if float('-inf') in maxNums else maxNums[2]
            