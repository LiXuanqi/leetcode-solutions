class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        @functools.lru_cache(None)
        def dfs(start, k):
            if start >= len(nums) and k == 0:
                return 0
            
            if k == 0 or start >= len(nums):
                return float('-inf')
            
            max_val = 0
            for end in range(start + 1, len(nums) + 1):
                val = sum(nums[start:end]) / (end - start) + dfs(end, k - 1)
                max_val = max(max_val, val)
                
            return max_val
        
        return dfs(0, k)
                
            
        
