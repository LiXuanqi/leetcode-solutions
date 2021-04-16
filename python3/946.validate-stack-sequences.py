class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        i = 0
        j = 0
        stack = []
        while i < len(pushed) and j < len(popped):
            # if not stack and i < len(pushed):
            #     stack.append(pushed[i])
            #     i += 1
            #     continue
            
            if stack and j < len(popped) and stack[-1] == popped[j]:
                stack.pop()
                j += 1
                continue
            else:
                stack.append(pushed[i])
                i += 1 
                
        # print(i, j, stack)
        
        if i != len(pushed):
            return False
        
        while j < len(popped):
            if stack and j < len(popped) and stack[-1] == popped[j]:
                stack.pop()
                j += 1
            else:
                return False
        # print(i, j, stack)      
        return not stack
        
