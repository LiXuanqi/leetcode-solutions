class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.word_to_indexes = collections.defaultdict(list)
        for index, word in enumerate(wordsDict):
            self.word_to_indexes[word].append(index)
            
        

    def shortest(self, word1: str, word2: str) -> int:
        indexes_1 = self.word_to_indexes[word1]
        indexes_2 = self.word_to_indexes[word2]
        
        i = 0
        j = 0
        ans = float('inf')
        while i < len(indexes_1) and j < len(indexes_2):
            dist = abs(indexes_1[i] - indexes_2[j])
            ans = min(ans, dist)
            
            if indexes_1[i] < indexes_2[j]:
                i += 1
            else:
                j += 1
                
        while i < len(indexes_1):
            dist = abs(indexes_1[i] - indexes_2[j - 1])
            ans = min(ans, dist)
            i += 1
            
        while j < len(indexes_2):
            dist = abs(indexes_1[i - 1] - indexes_2[j])
            ans = min(ans, dist)
            j += 1
            
        return ans
            
            
        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
