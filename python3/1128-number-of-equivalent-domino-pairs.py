class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        if not dominoes:
            return 0
        
        dominoesMap = {}
        for domino in dominoes:
            k = tuple(sorted(domino))
            dominoesMap[k] = dominoesMap.get(k, 0) + 1
        
        def getCombination(n):
            s = 0
            for i in range(n):
                s += i
            return s
        ans = 0
        for val in dominoesMap.values():
            ans += getCombination(val)
        return ans
            
            
        