class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n <= 1:
            return n
        uglys = [1]
        index2 = 0
        index3 = 0
        index5 = 0
        for _ in range(n):
            minVal = min(uglys[index2] * 2, uglys[index3] * 3, uglys[index5] * 5)
            uglys.append(minVal)
            if uglys[index2] * 2 == minVal:
                index2 += 1
            if uglys[index3] * 3 == minVal:
                index3 += 1
            if uglys[index5] * 5 == minVal:
                index5 += 1
        return uglys[n - 1]
        