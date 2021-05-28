class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> int:
        heap = [(0, 0, 0)]
        
        visited = set()
   
        
        while heap:
            curr_cost, curr_match_id, used_bikes = heapq.heappop(heap)
            
            if used_bikes in visited:
                continue
            
            visited.add(used_bikes)
    
            if curr_match_id == len(workers):
                return curr_cost
            
            for i, bike in enumerate(bikes):
               
      
         
                if used_bikes & (1 << i) == 0:
                    heapq.heappush(
                        heap, 
                        (curr_cost + get_distance(bike, workers[curr_match_id]), curr_match_id + 1, used_bikes | (1 << i))
                    )
                    
                    
        return -1
    
def get_distance(bike, worker):
    return abs(bike[0] - worker[0]) + abs(bike[1] - worker[1])
        
        
