class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        if not pattern or not str:
            return False
        words = str.split(' ')
        
        if len(words) != len(pattern):
            return False
        
        seen = set()
        map = {}

        for index, word in enumerate(words):
            c = pattern[index]
            if word not in seen:
                if c not in map:
                    map[c] = word
                    seen.add(word)
                else:
                    return False
            else:
                if c not in map or map[c] != word:
                    return False
        return True
                