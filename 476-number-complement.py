class Solution:
    def findComplement(self, num: int) -> int:
        i = 1
        while i <= num:
            i = i << 1
        return (i - 1) ^ num