class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        if not wordDict or len(wordDict) == 0:
            return False
        if not s or len(s) == 0:
            return True
        dict = set(wordDict)
        # - get max length
        maxLength = 0
        for word in wordDict:
            maxLength = max(maxLength, len(word))
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(1, len(dp)):
            start = max(0, i - maxLength)
            for j in range(start, i):
                if s[j:i] in dict and dp[j]:
                    dp[i] = True
        return dp[-1]
        