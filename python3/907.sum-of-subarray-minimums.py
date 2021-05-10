MOD = 10 ** 9 + 7

class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        lefts = find_prev_small(arr)
        rights = find_next_small(arr)

        
        ans = 0
        
        for i, num in enumerate(arr):
            left_nums = (i - lefts[i]) if lefts[i] != -1 else (i + 1)
            right_nums = (rights[i] - i) if rights[i] != -1 else (len(rights) - i)

            ans = (ans + num * left_nums * right_nums) % MOD
        return ans
    
def find_prev_small(nums):
    
    ans = []
    
    stack = []
    
    for index, num in enumerate(nums):
        while stack and nums[stack[-1]] > num:
            stack.pop()
        
        ans.append(stack[-1] if stack else -1)
        
        stack.append(index)
        
    return ans
        
    
def find_next_small(nums):
    
    ans = [-1] * len(nums)
    
    stack = []
    
    for index in range(len(nums) - 1, -1, -1):
        num = nums[index]
        while stack and nums[stack[-1]] >= num:
            stack.pop()
        
        ans[index] = stack[-1] if stack else -1
        
        stack.append(index)
        
    return ans
        
        
            
        
