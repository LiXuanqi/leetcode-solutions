#
# @lc app=leetcode id=1037 lang=python3
#
# [1037] Valid Boomerang
#
class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        if not points or len(points) != 3:
            return False
        pointSet = set()
        for point in points:
            pointSet.add(tuple(point))
        point1, point2, point3 = points
        if point1[0] == point2[0] == point3[0] or point1[1] == point2[1] == point3[1]:
            return False
        if len(pointSet) != 3:
            return False
        def getSlope(point1, point2):
            if point2[0] - point1[0] == 0:
                return None
            return (point2[1] - point1[1]) / (point2[0] - point1[0])

        return getSlope(point1, point2) != getSlope(point2, point3)
