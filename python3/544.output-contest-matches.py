class Solution:
    def findContestMatch(self, n: int) -> str:
    
        
        def match(teams):
            if len(teams) == 1:
                return teams
            ans = []
            for i in range(len(teams) // 2):
                ans.append("(%s,%s)" % (teams[i], teams[-(1 + i)]))
            return match(ans)
            
        ans = match([i for i in range(1, n + 1)])
        return ans[0]