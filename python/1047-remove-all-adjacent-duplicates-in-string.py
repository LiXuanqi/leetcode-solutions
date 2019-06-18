class Solution:
    def removeDuplicates(self, S: str) -> str:
        if not S:
            return ""
        stack = []
        for c in S:
            if not stack or stack[-1] != c:
                stack.append(c)
            else:
                stack.pop()
        return "".join(stack)
        
