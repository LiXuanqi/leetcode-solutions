#
# @lc app=leetcode id=862 lang=python3
#
# [862] Shortest Subarray with Sum at Least K
#
class Solution:
    def shortestSubarray(self, A: List[int], K: int) -> int:
        prefixSum = [0]
        curr_sum = 0
        for num in A:
            curr_sum += num
            prefixSum.append(curr_sum)        

        ans = float('inf') 
        deque = collections.deque()        
        deque.append(0)
        for end in range(1, len(A) + 1):
            while deque and prefixSum[end] - prefixSum[deque[0]] >= K:
                ans = min(ans, end - deque.popleft())
            while deque and prefixSum[end] <= prefixSum[deque[-1]]:
                deque.pop()
            deque.append(end)

        return ans if ans != float('inf') else -1

