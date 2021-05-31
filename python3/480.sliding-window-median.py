class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        
        min_heap = []
        max_heap = []
        
        # initialize
        for index, num in enumerate(nums[:k]):
            heapq.heappush(min_heap, (num, index))
        
        while len(min_heap) > len(max_heap):
            move(min_heap, max_heap)
            
        ans = [get_median(min_heap, max_heap, k)]
            
        for index in range(k, len(nums)):
            inserted_num = nums[index]
            deleted_num = nums[index - k]
            if min_heap and inserted_num >= min_heap[0][0]:
                heapq.heappush(min_heap, (inserted_num, index))
                if deleted_num <= -max_heap[0][0]:
                    move(min_heap, max_heap)
            else:
                heapq.heappush(max_heap, (-inserted_num, index))
                if min_heap and deleted_num >= min_heap[0][0]:
                    move(max_heap, min_heap)
            
            while min_heap and min_heap[0][1] <= index - k:
                heapq.heappop(min_heap)
            while max_heap and max_heap[0][1] <= index - k:
                heapq.heappop(max_heap)
                
            ans.append(get_median(min_heap, max_heap, k))
        
        return ans
            
            
def move(heap_1, heap_2):
    num, index = heapq.heappop(heap_1)
    heapq.heappush(heap_2, (-num, index))
        
        
def get_median(min_heap, max_heap, k):
 
    if k % 2 == 0:
        return (min_heap[0][0] - max_heap[0][0]) / 2
    else:
        return -max_heap[0][0]
    
