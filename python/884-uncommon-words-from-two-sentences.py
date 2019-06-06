class Solution:
    def uncommonFromSentences(self, A: str, B: str) -> List[str]:
        wordMap = {}
        aWords = A.split(" ")
        bWords = B.split(" ")
        for word in aWords + bWords:
            if word not in wordMap:
                wordMap[word] = 0
            wordMap[word] += 1
        ans = [] 
        for key, value in wordMap.items():
            if value == 1:
                ans.append(key)
        return ans