class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        
        nums = nums * 2
        
        stack = []
        
        for index, num in enumerate(nums):
            while stack and num > nums[stack[-1]]:
                last_index = stack.pop()
                ans[last_index] = num
                
            if index < n:
                stack.append(index)
                
        return ans
        
