class Solution:
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        time = math.ceil(len(B) / len(A))
        if B in A * time:
            return time
        if B in A * (time + 1):
            return time + 1
        return -1
        