class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        
        def dfs(index, rest, temp):
            if rest == 0:
                ans.append(translate(temp, candidates))
                return
            if index == len(candidates) or rest < 0:
                return
            
            for time in range(rest // candidates[index] + 1):
                temp.append(time)
                dfs(index + 1, rest - time * candidates[index], temp)
                temp.pop()
                
        dfs(0, target, [])
        return ans
    
def translate(times, candidates):
    ans = []
    for i in range(len(times)):
        ans.extend([candidates[i]] * times[i])
    return ans
                
        
