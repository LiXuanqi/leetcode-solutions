class Solution:
    def shortestWordDistance(self, words: 'List[str]', word1: 'str', word2: 'str') -> 'int':      
        wordToPositions = {}
        for index, word in enumerate(words):
            wordToPositions.setdefault(word, []).append(index)
        list1 = wordToPositions[word1]
        list2 = wordToPositions[word2]
        p1 = 0
        p2 = 0
        ans = float('inf')
        while p1 < len(list1) and p2 < len(list2):
            diff = abs(list1[p1] - list2[p2])
            if diff != 0:
                ans = min(ans, diff)
            if list1[p1] < list2[p2]:
                p1 += 1
            else:
                p2 += 1
        return ans
                