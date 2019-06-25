class Solution:
    def fixedPoint(self, A: List[int]) -> int:
        if not A:
            return -1
        for index, value in enumerate(A):
            if index == value:
                return index
        return -1
        