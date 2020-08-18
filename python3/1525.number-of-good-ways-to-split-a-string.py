
class Solution:
    def numSplits(self, s: str) -> int:
        distinct_letters_from_left = [0] * len(s)
        distinct_letters_from_right = [0] * len(s)
        character_set = set()
        freq = 0
        for index, c in enumerate(s):
            character_set.add(c)
            distinct_letters_from_left[index] = len(character_set)
            
        character_set = set()   
        freq = 0
        for index, c in enumerate(reversed(s)):
            character_set.add(c)
            distinct_letters_from_right[len(s)-index-1] = len(character_set) 
        ans = 0
        for i in range(0, len(s)-1):
            if distinct_letters_from_left[i] == distinct_letters_from_right[i+1]:
                ans += 1
        return ans
