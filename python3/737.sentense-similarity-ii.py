class Solution:
    
    def areSentencesSimilarTwo(self, words1: List[str], words2: List[str], pairs: List[List[str]]) -> bool:
        self.parents = {}
        if len(words1) != len(words2):
            return False
        # union find
        for word1, word2 in pairs:
            if word1 not in self.parents:
                self.parents[word1] = word1
            if word2 not in self.parents:
                self.parents[word2] = word2
            self.union(word1, word2)
        
        for i in range(len(words1)):
            word1 = words1[i]
            word2 = words2[i]
            if not self.is_similar(word1, word2):
                return False
        return True
                
        
    def union(self, word1, word2):
        parent1 = self.find(word1)
        parent2 = self.find(word2)
        if  parent1 != parent2:
            self.parents[parent1] = parent2
            
    def find(self, word):
        if word not in self.parents:
            return word
        curr = word
        while self.parents[curr] != curr:
            curr = self.parents[curr]
        parent = curr
        curr = word
        while self.parents[curr] != curr:
            next = self.parents[curr]
            self.parents[curr] = parent
            curr = next
        return parent

    def is_similar(self, word1, word2):
        return self.find(word1) == self.find(word2)

    
        
        