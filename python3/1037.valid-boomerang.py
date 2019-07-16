#
# @lc app=leetcode id=1037 lang=python3
#
# [1037] Valid Boomerang
#
class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        a, b, c = points
        xa, ya = a
        xb, yb = b
        xc, yc = c
        return (yb - ya) * (xc - xa) != (xb - xa) * (yc - ya)
