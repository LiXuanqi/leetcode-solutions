class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        n = len(nums)
        
        curr_window = sum(nums[:-1])
        curr_tail_index = -1
        
        curr_score = 0
        for index, num in enumerate(nums):
            curr_score += (index * num)
        
        max_score = curr_score
        
        for _ in range(n - 1):
            curr_score = curr_score + curr_window - nums[curr_tail_index] * (n - 1)
        
            curr_tail_index -= 1
            curr_window = curr_window - nums[curr_tail_index] + nums[curr_tail_index + 1]
           
            
            max_score = max(max_score, curr_score)
            
        return max_score
            
            
            
        
        

        
