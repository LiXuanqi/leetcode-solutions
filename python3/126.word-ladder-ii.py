class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordList = set(wordList)
        if endWord not in wordList:
            return []
        
        distances = {} # distance from beginWord
        distances[beginWord] = 0
        graph = {}
        
        ans = []
        
        def bfs():
            queue = collections.deque()
            queue.append(beginWord)
            step = 1
            while queue:
                size = len(queue)
                for i in range(size):
                    curr = queue.popleft()
                    if curr == endWord:
                        return
                    for word in getNextWords(curr):
                        graph.setdefault(curr, []).append(word) # build graph
                        if word not in distances or distances[word] > step:
                            queue.append(word)
                            distances[word] = step
                step += 1
           
                
        def dfs(currWord, path, step):
            if currWord == endWord:
                ans.append(path.copy())
                return
            for word in graph.get(currWord, []):
                if distances[word] == step + 1:
                    path.append(word)
                    dfs(word, path, step + 1)
                    path.pop()
            
                    
                
        def getNextWords(word):
            nextWords = []
            for index in range(len(word)):
                for c in range(ord('a'), ord('z') + 1):
                    if chr(c) == word[index]:
                        continue
                    newWord = word[:index] + chr(c) + word[index + 1:]
                    if newWord in wordList:
                        nextWords.append(newWord)
            return nextWords
        
        bfs()
        dfs(beginWord, [beginWord], 0)
        return ans
    