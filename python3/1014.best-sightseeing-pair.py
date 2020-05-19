class Solution:
    def maxScoreSightseeingPair(self, A: List[int]) -> int:
        left = 0
        ans = A[left] + A[1] - 1
        for index in range(1, len(A)):
            sum = A[left] + A[index] + left - index
            ans = max(ans, sum)
            if A[left] + left < A[index] + index:
                left = index
        return ans