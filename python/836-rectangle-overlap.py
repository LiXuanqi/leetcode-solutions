from collections import namedtuple
class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        Interval = namedtuple('Interval', 'start, end')
        intervalX1 = Interval(rec1[0], rec1[2])
        intervalY1 = Interval(rec1[1], rec1[3])
        intervalX2 = Interval(rec2[0], rec2[2])
        intervalY2 = Interval(rec2[1], rec2[3])
        return all([isOverlap(intervalX1, intervalX2), isOverlap(intervalY1, intervalY2)])
    
def isOverlap(interval1, interval2):
    return not any([interval1.end <= interval2.start, interval2.end <= interval1.start])