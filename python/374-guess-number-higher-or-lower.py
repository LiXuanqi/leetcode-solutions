# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        start = 1
        end = n
        while start + 1 < end:
            mid = start + (end - start) / 2
            result = guess(mid)
            if result == 0:
                return mid
            elif result == 1:
                start = mid
            else:
                end = mid
        if guess(start) == 0:
            return start
        if guess(end) == 0:
            return end
        return 0