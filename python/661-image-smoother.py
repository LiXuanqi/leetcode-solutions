class Solution(object):
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        rowNum, colNum = len(M), len(M[0])
        ans = [[0] * colNum for _ in range(rowNum)]
        for i in range(rowNum):
            for j in range(colNum):
                ans[i][j] = smooth(i, j, M)
        return ans

def smooth(i, j, nums):
    count = 0
    total = 0
    for x in (i - 1, i, i + 1):
        for y in (j - 1, j, j + 1):
            if inBound(x, y, nums):
                count += 1
                total += nums[x][y]
    return total // count

def inBound(i, j, nums):
    return 0 <= i and i < len(nums) and 0 <= j and j < len(nums[0])