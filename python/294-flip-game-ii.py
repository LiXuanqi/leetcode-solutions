class Solution:
    memos = {}
    def canWin(self, s: str) -> bool:
        if not s or len(s) < 2:
            return False
        if s in self.memos:
            return self.memos[s]
        for i in range(1, len(s)):
            word = s[i - 1: i + 1]
            if word == "++":
                if not self.canWin(s[:i - 1] + "--" + s[i + 1:]):
                    self.memos[s] = True
                    return True
                
        self.memos[s] = False
        return False