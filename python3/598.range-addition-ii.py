class Solution:
    def maxCount(self, m, n, ops):
        """
        :type m: int
        :type n: int
        :type ops: List[List[int]]
        :rtype: int
        """
        minM = m
        minN = n
        for op in ops:
            minM = min(minM, op[0])
            minN = min(minN, op[1])
        return minM * minN