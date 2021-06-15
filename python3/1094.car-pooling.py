class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        # interval to point
        points = []
        
        for num_passengers, start, end in trips:
            points.append((start, num_passengers))
            points.append((end, -num_passengers))
            
        points.sort()
        
        curr_passengers = 0
        
        for _, num_passengers in points:
            curr_passengers += num_passengers
            if curr_passengers > capacity:
                return False
            
        return True
        
        
