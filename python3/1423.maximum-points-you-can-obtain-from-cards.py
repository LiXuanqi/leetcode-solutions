class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        left = len(cardPoints) - k
        right = 0
        max_sum = curr_sum = sum(cardPoints[left:])
        for _ in range(k):
            curr_sum = curr_sum - cardPoints[left] + cardPoints[right]
            max_sum = max(max_sum, curr_sum)
            left += 1
            right += 1
        return max_sum