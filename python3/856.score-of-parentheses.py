class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        stack = []
        for c in s:
            if c == '(':
                stack.append('(')
                
            elif c == ')':
                curr_num = 0
                while stack and stack[-1] != '(':
                    curr_num += stack.pop()
                
                stack.pop()
                stack.append(1 if curr_num == 0 else curr_num * 2)
                
        return sum(stack)
                    
                    
        
