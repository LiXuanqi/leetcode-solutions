# Solution 1: deque
# Time: O(n)
class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        min_deque = collections.deque()
        max_deque = collections.deque()
        ans = 0
        left = 0
        for right, num in enumerate(nums):
            while min_deque and nums[min_deque[-1]] > num:
                min_deque.pop()
            min_deque.append(right)
            while max_deque and nums[max_deque[-1]] < num:
                max_deque.pop()
            max_deque.append(right)
            
            while nums[max_deque[0]] - nums[min_deque[0]] > limit:
                left = min(max_deque[0], min_deque[0]) + 1
                
                if max_deque[0] < left:
                    max_deque.popleft()
                if min_deque[0] < left:
                    min_deque.popleft()
                    
            ans = max(ans, right - left + 1)
            
        return ans
        
# Solution 2:
# Time: O(nlogn)
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
