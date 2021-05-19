class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        
        while left + 1 < right:
            mid = (left + right) // 2
       
            if can_finish(piles, h, mid):
                right = mid
            else:
                left = mid
                
        if can_finish(piles, h, left):
            return left
        return right
    
def can_finish(piles, limit, speed):
    curr_hour = 0
    for index, pile in enumerate(piles):
        curr_hour += (pile / speed)
        curr_hour = math.ceil(curr_hour)
    return curr_hour <= limit
    
        
