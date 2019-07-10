class Solution:
    def shortestToChar(self, S: str, C: str) -> List[int]:
        if not S:
            return []
        
        def fill(start, end):
            distance = 0
            while start <= end:
                ans[start] = distance
                ans[end] = distance
                distance += 1
                start += 1
                end -= 1    
        
        zeros = []
        for index, c in enumerate(S):
            if c == C:
                zeros.append(index)
        ans = [0] * len(S)
        if len(zeros) > 1:
            for i in range(1, len(zeros)):
                fill(zeros[i - 1], zeros[i])
        distance = 0
        for i in reversed(range(0, zeros[0] + 1)):
            ans[i] = distance
            distance += 1
        distance = 0
        for i in range(zeros[-1], len(ans)):
            ans[i] = distance
            distance += 1
            
      
        
        return ans
        
        
        
                
            