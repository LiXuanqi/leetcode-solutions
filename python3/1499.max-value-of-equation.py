class Solution:
    def findMaxValueOfEquation(self, points: List[List[int]], k: int) -> int:
        # yi + yj + |xi - xj| = yi + yj + xj - xi = (xj + yj) + (yi - xi)
        dec_stack = collections.deque()
        ans = float('-inf')
        for index, point in enumerate(points):
            while dec_stack and points[index][0] - points[dec_stack[0]][0] > k:
                dec_stack.popleft()
            if dec_stack:
                ans = max(ans, point[0] + point[1] + points[dec_stack[0]][1] - points[dec_stack[0]][0])
            while dec_stack and points[dec_stack[-1]][1] - points[dec_stack[-1]][0] <= point[1] - point[0]:
                dec_stack.pop()
            dec_stack.append(index)
            
        return ans
        
