class Solution:
    def areSentencesSimilar(self, words1: List[str], words2: List[str], pairs: List[List[str]]) -> bool:
        if len(words1) != len(words2):
            return False
        # - build dict
        d = {}
        for word1, word2 in pairs:
            d.setdefault(word1, []).append(word2)
            d.setdefault(word2, []).append(word1)
        for i in range(len(words1)):
            if words1[i] == words2[i]:
                continue
            if words1[i] in d.get(words2[i], '') or words2[i] in d.get(words1[i], ''):
                continue
            return False
        return True
        
            
        