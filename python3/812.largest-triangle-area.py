#
# @lc app=leetcode id=812 lang=python3
#
# [812] Largest Triangle Area
#
class Solution:
    def largestTriangleArea(self, points: List[List[int]]) -> float:
        if not points:
            return 0
        def calculateArea(a, b, c):
            xa, ya = a
            xb, yb = b
            xc, yc = c
            return abs(xa * yb + xb * yc + xc * ya - xa * yc - xb * ya - xc * yb) / 2
            
        ans = 0
        for x in range(len(points) - 2):
            for y in range(x + 1, len(points) - 1):
                for z in range(y + 1, len(points)):
                    area = calculateArea(points[x], points[y], points[z])
                    ans = max(ans, area)
        
        return ans
                    

