# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def merge(self, intervals: List[Interval]) -> List[Interval]:
        if intervals is None or len(intervals) <= 1:
            return intervals
        intervals = sorted(intervals, key=lambda interval: interval.start)
        prev = intervals[0]
        ans = []
        for i in range(1, len(intervals)):
            curr = intervals[i]
            if prev.end < curr.start:
                ans.append(prev)
                prev = curr
            else:
                prev.start = min(prev.start, curr.start)
                prev.end = max(prev.end, curr.end)
        ans.append(prev)
        return ans