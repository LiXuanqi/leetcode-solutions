# solution: quick select 
# Time: O(n)  faster than 53.12%
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        points = [(distance_to_origin(point), point) for point in points]
        quick_select(points, 0, len(points) - 1, k)
        return [point[1] for point in points[:k]]

def quick_select(points, start, end, k):
    
    if start >= end:
        return
    
    left = start
    right = end
    mid = (left + right) // 2
    pivot = points[mid][0]
    while left <= right:
        while left <= right and points[left][0] < pivot:
            left += 1
        
        while left <= right and points[right][0] > pivot:
            right -= 1
            
        # swap
        if left <= right:
            temp = points[left]
            points[left] = points[right]
            points[right] = temp
            left += 1
            right -= 1
        # if left = right before swap, there is one element between right and left pointer.
    
    if right >= k:
        quick_select(points, start, right, k)
    elif k >= left:
        quick_select(points, left, end, k)
        
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
