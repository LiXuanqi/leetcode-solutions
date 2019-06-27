class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        if not points:
            return 0
        ans = 0
        for index, point in enumerate(points):
            slopes = {}
            xs = {}
            duplicate = 1
            x1, y1 = point
            for x2, y2 in points[index + 1:]:
                if x1 == x2 and y1 == y2:
                    duplicate += 1
                elif x2 - x1 == 0:
                    x = x1
                    xs[x] = xs.get(x, 0) + 1
                else:
                    slope = (y2 - y1) / (x2 - x1)
                    slopes[slope] = slopes.get(slope, 0) + 1
            for value in slopes.values():
                ans = max(ans, value + duplicate)
            for value in xs.values():
                ans = max(ans, value + duplicate)
            ans = max(ans, duplicate)
        return ans
        