class Solution:
    def isReflected(self, points: List[List[int]]) -> bool:
        # group by y and then sort by x
        grouped_points = collections.defaultdict(list)
        mid_axis = None
        for x, y in points:
            grouped_points[y].append(x)
        print(grouped_points)
        for k in grouped_points:
            xs = sorted(set(grouped_points[k]))
            curr_mid_axis = get_mid_axis(xs)
            if curr_mid_axis is None:
                return False
            else:
                if mid_axis is not None and mid_axis != curr_mid_axis:
                    return False
                mid_axis = curr_mid_axis
        return True
    
def get_mid_axis(xs):
    # all points have same x
    left = 0
    right = len(xs) - 1
    mid_axis = (xs[0] + xs[-1]) / 2
    # print(mid_axis)
    while left <= right:
        if xs[left] + xs[right] != mid_axis * 2:
            return None
        left += 1
        right -= 1
    return mid_axis
        
                
        
        