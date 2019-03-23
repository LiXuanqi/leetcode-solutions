class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        maxXs = [0] * len(grid)
        maxYs = [0] * len(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                num = grid[i][j]
                # - update max array.
                maxXs[i] = max(maxXs[i], num)
                maxYs[j] = max(maxYs[j], num)
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                maxValue = min(maxXs[i], maxYs[j])
                if maxValue > grid[i][j]:
                    ans += maxValue - grid[i][j]
        return ans
                