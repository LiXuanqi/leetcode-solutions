class ValidWordAbbr:
    
    def __init__(self, dictionary: List[str]):
        self.m = {}
        for word in dictionary:
            abbr = self.getAbbr(word)
            l = self.m.get(abbr, set())
            l.add(word)
            self.m[abbr] = l

    def isUnique(self, word: str) -> bool:
        abbr = self.getAbbr(word)
        words = self.m.get(abbr)
        return words is None or (len(words) == 1 and word in words)
        
    def getAbbr(self, word):
        if len(word) <= 2:
            return word
        return word[0] + str(len(word) - 2) + word[-1]

# Your ValidWordAbbr object will be instantiated and called as such:
# obj = ValidWordAbbr(dictionary)
# param_1 = obj.isUnique(word)