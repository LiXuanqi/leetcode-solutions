class Solution:
    def visiblePoints(self, points: List[List[int]], angle: int, location: List[int]) -> int:
        angles = []
        exact_points = 0
        for point in points:
            if point == location:
                exact_points += 1
            else:
                angles.append(to_angle(point, location))
        
        # [-pi, +pi]
        angles.sort()
        angles.extend([angle + 2 * math.pi for angle in angles])
        angle = angle / 180 * math.pi
        
        left = 0
        ans = 0
        for right in range(len(angles)):
            while angles[right] - angles[left] > angle:
                left += 1
            ans = max(ans, right - left + 1)
        return ans + exact_points
        
             
        
def to_angle(point, location):
    return math.atan2(point[1] - location[1], point[0] - location[0])
    
        