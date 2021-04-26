class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        min_heap = []
        max_heap = []
        ans = 0
        left = 0
        for right, num in enumerate(nums):
            heapq.heappush(min_heap, (num, right))
            heapq.heappush(max_heap, (-num, right))
            
            while abs(min_heap[0][0] + max_heap[0][0]) > limit:
                left = min(min_heap[0][1], max_heap[0][1]) + 1
                while min_heap[0][1] < left:
                    heapq.heappop(min_heap)
                while max_heap[0][1] < left:
                    heapq.heappop(max_heap)
            
            
            ans = max(ans, right - left + 1)
        
        return ans
