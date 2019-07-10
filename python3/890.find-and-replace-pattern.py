class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        if not words or not pattern:
            return []
        
        def isMatch(word, pattern):
            seen = set()
            map = {}
            for index, c in enumerate(word):
                p = pattern[index]
                if c in seen:
                    if p not in map or map[p] != c:
                        return False
                else:
                    if p in map:
                        return False
                    seen.add(c)
                    map[p] = c
            return True
        
        ans = []
        for word in words:
            if isMatch(word, pattern):
                ans.append(word)
        return ans