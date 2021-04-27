        
# Solution: maintain the max-heap with size k
# Time: O(nlogk)  faster than 46.58%
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        max_heap = []
        for point in points:
            distance = distance_to_origin(point)
            heapq.heappush(max_heap, (-distance, point))
            # maintain max_heap with size k
            while len(max_heap) > k:
                heapq.heappop(max_heap)
        
        return [item[1] for item in max_heap]
        

# Solution: heapify + pop() k times
# Time = O(n + klogn) faster than 69.84%
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        points = [(distance_to_origin(point), point) for point in points]
        heapq.heapify(points)
        ans = []
        for _ in range(k):
            ans.append(heapq.heappop(points)[1])
            
        return ans
        
        
def distance_to_origin(point):
    return point[0] ** 2 + point[1] ** 2
