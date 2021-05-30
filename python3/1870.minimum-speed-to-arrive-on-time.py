class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
      
        left = 1
        right = max(dist)
                    
        if hour % 1 != 0:
            right = max(right, math.ceil(dist[-1] / (hour % 1)))
        
        while left + 1 < right:
            mid = (left + right) // 2
            if can_reach(dist, hour, mid):
                right = mid
            else:
                left = mid
                
        if can_reach(dist, hour, left):
            return left
        if can_reach(dist, hour, right):
            return right
        return -1
    
def can_reach(dist, limit_hour, speed):
    curr_time = 0
    for i in range(len(dist)):
        
        curr_time += (dist[i] / speed)
        if i != len(dist) - 1:
            curr_time = math.ceil(curr_time)
       
    return curr_time <= limit_hour
            
        
