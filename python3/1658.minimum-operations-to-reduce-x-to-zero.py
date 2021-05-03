class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        left = 0
        curr_sum = sum(nums)
        if curr_sum < x:
            return -1
        elif curr_sum == x:
            return len(nums)
        
        ans = float('inf')
        
        for right in range(len(nums)):
            curr_sum -= nums[right]
            
            while curr_sum < x and left < right:
                curr_sum += nums[left]
                left += 1
            if curr_sum == x:
                ans = min(ans, len(nums) - right - 1 + left)
                
        return ans if ans != float('inf') else -1
                
        