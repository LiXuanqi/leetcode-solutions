class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        counter = collections.defaultdict(int)
        for c in s:
            counter[c] += 1
        
        visited = set()
        
        stack = []
        
        for c in s:
            
            if c not in visited:
                
                while stack and stack[-1] > c and counter[stack[-1]] > 0:
                    visited.remove(stack.pop())
                    

                stack.append(c)
                visited.add(c)
                
            counter[c] -= 1
            
        return "".join(stack)        
