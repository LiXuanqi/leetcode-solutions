class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        if not words:
            return []
        rows = ["qwertyuiop", "asdfghjkl", "zxcvbnm"]
        keyboard = {}
        for index, row in enumerate(rows):
            for key in row:
                keyboard[key] = index
                
        def isInOneLine(word):
            row = -1
            for character in word:
                position = keyboard[character.lower()]
                if row == -1:
                    row = position
                elif row != position:
                    return False
            return True
        ans = []
        for word in words:
            if isInOneLine(word):
                ans.append(word)
        return ans
                    
                    