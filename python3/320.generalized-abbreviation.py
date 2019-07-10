class Solution:
    def generateAbbreviations(self, word: str) -> List[str]:
        if not word:
            return [""]
        sb = []
        ans = set()
        def dfs(start, count, temp):
            if start == len(word):
                if count > 0:
                    temp += str(count)
                ans.add(temp)
                return
            
            dfs(start + 1, count + 1, temp)
            dfs(start + 1, 0, temp + (str(count) if count > 0 else "") + word[start])
        dfs(0, 0, "")
        return list(ans)
                
                
                