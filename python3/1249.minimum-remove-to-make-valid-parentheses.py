class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        removed = []
        for index, c in enumerate(s):
            if c == ')':
                if not stack:
                    removed.append(index)
                else:
                    stack.pop()
            elif c == '(':
                stack.append(index)
                
        removed = set(removed) | set(stack)
        
        # print(removed)
        
        return ''.join([c for i, c in enumerate(s) if i not in removed])
        
