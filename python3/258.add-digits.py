class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        s = str(num)
        if len(s) == 1:
            return num
        total = 0
        for c in s:
            total += int(c)
        return self.addDigits(total)