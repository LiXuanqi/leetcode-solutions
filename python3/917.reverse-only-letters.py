class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        S = list(S)
        left = 0
        right = len(S) - 1
        while left < right:
            while left < right and not S[left].isalpha():
                left += 1
            while left < right and not S[right].isalpha():
                right -= 1
            temp = S[left]
            S[left] = S[right]
            S[right] = temp
            left += 1
            right -= 1
        return "".join(S)
