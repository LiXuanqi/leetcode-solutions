class Solution:
    def areSentencesSimilar(self, words1: List[str], words2: List[str], pairs: List[List[str]]) -> bool:
        if len(words1) != len(words2):
            return False
        # - build dict
        pairset = set(map(tuple, pairs))
        return all([
            word1 == word2 or
            (word1, word2) in pairset or
            (word2, word1) in pairset
            for word1, word2 in zip(words1, words2)
        ])
        
            
        