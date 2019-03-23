class Solution:
    def rotatedDigits(self, N: int) -> int:
        ans = 0
        for i in range(1, N + 1):
            S = str(i)
            ans += (all([c not in '347' for c in S]) and any([c in '2569' for c in S]))
        return ans