class Solution:
    def minAreaRect(self, points: List[List[int]]) -> int:
        points_set = set(tuple(point) for point in points)
        n = len(points)
        
        ans = float('inf')
        
        for i in range(n - 1):
            for j in range(i + 1, n):
                x1, y1 = points[i]
                x2, y2 = points[j]
                if x1 == x2 and y1 == y2:
                    continue
                if (x1, y2) in points_set and (x2, y1) in points_set:
                    area = abs(x1 - x2) * abs(y1 - y2)
                    if area != 0 and area < ans:
                        ans = area
        return ans if ans != float('inf') else 0
        
