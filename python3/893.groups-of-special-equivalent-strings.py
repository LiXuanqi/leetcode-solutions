class Solution:
    def numSpecialEquivGroups(self, A: List[str]) -> int:
        if not A:
            return 0
        
        def splitWord(word):
            charMap = [0] * 52
            for index, letter in enumerate(word):
                charMap[ord(letter) - ord('a') + 26 * (index % 2)] += 1
            return tuple(charMap)
        
        return len({splitWord(word) for word in A})