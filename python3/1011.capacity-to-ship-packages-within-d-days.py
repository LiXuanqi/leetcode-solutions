class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left = max(weights)
        right = sum(weights)
        
        while left + 1 < right:
            mid = (left + right) // 2
            if can_ship(weights, mid, days):
                right = mid
            else:
                left = mid
                
        if can_ship(weights, left, days):
            return left
        
        return right
    
def can_ship(weights, ship, limit_day):
  
    day = 0
    capacity = 0
    for weight in weights:
        if capacity + weight <= ship:
            capacity += weight
        else:
            capacity = weight
            day += 1
        
        
    if capacity != 0:
        day += 1
    
    return day <= limit_day
        
