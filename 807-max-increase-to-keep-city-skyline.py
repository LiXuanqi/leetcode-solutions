class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        maxXs = [max(row) for row in grid]
        maxYs = [max(col) for col in zip(*grid)]
        return sum(
            min(maxXs[i], maxYs[j]) - val
            for i, row in enumerate(grid)
            for j, val in enumerate(row)
        )
                