class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        curr_max = float('-inf')
        ans = 0
        for index, num in enumerate(arr):
            curr_max = max(curr_max, num)
            if index == curr_max:
                ans += 1
        return ans
            
            
        
            
            
            