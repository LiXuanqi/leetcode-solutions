# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if intervals is None or len(intervals) == 0:
            return 0
        points = []
        for interval in intervals:
            points.append(Point(interval.start, True))
            points.append(Point(interval.end, False))
        points = sorted(points, key=lambda p: (p.pos, p.isStart))
        ans = 0
        room = 0
        for point in points:
            if point.isStart:
                room += 1
            else:
                room -= 1
            ans = max(ans, room)
        return ans
    
class Point:
    def __init__(self, pos, isStart):
        self.pos = pos
        self.isStart = isStart
    def __repr__(self):
        return "(%s, %s)" % (self.pos, self.isStart)