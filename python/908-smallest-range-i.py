class Solution:
    def smallestRangeI(self, A: List[int], K: int) -> int:
        maxNum = max(A)
        minNum = min(A)
        return 0 if minNum + K >= maxNum - K else maxNum - minNum - 2 * K 