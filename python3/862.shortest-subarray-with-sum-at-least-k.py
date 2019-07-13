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

        def getIntervalSum(start, end): 
            return prefixSum[end + 1] - prefixSum[start]
        ans = float('inf') 
        for start in range(len(A)):
            for end in range(start, len(A)):
                intervalSum = getIntervalSum(start ,end)
                if intervalSum >= K:
                    ans = min(end - start + 1, ans)
        
        return ans if ans != float('inf') else -1

