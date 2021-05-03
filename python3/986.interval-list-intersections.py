BEGIN = 'begin'
END = 'end'

class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        points_first = intervals_to_points(firstList)
        points_second = intervals_to_points(secondList)
        
        # merge two sorted list
        points = merge(points_first, points_second)
        
        count = 0
        ans = []
        last_start = None
        for index, point_type in points:
            if point_type == BEGIN:
                count += 1
            elif point_type == END:
                if count == 2:
                    ans.append([last_start, index])
                count -= 1
                
            if count == 2:
                last_start = index
        
        return ans
        
        
def intervals_to_points(intervals):
    points = []
    for start, end in intervals:
        points.append((start, BEGIN))
        points.append((end, END))
    return points
        
        
def merge(points_1, points_2):
    points = []
    n, m = len(points_1), len(points_2)
    i = 0
    j = 0
    while i < n and j < m:
        if points_1[i][0] < points_2[j][0]:
            points.append(points_1[i])
            i += 1
        elif points_1[i][0] > points_2[j][0]:
            points.append(points_2[j])
            j += 1
        else:
            # BEGIN point should before END point
            if points_1[i][1] == BEGIN:
                points.append(points_1[i])
                i += 1
            else:
                points.append(points_2[j])
                j += 1
    while i < n:
        points.append(points_1[i])
        i += 1
    while j < m:
        points.append(points_2[j])
        j += 1
    return points
