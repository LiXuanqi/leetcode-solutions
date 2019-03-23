class Solution:
    def areSentencesSimilar(self, words1: List[str], words2: List[str], pairs: List[List[str]]) -> bool:
        if len(words1) != len(words2):
            return False
        # - build dict
        d = {}
        for word1, word2 in pairs:
            l1 = d.get(word1, [])
            l2 = d.get(word2, [])
            l1.append(word2)
            l2.append(word1)
            d[word1] = l1
            d[word2] = l2
        for i in range(len(words1)):
            if words1[i] == words2[i]:
                continue
            if words1[i] in d.get(words2[i], '') or words2[i] in d.get(words1[i], ''):
                continue
            return False
        return True
        
            
        