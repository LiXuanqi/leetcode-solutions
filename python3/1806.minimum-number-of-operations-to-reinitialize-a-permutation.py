class Solution:
    def reinitializePermutation(self, n: int) -> int:
        # If i % 2 == 0, then arr[i] = perm[i / 2].
        # If i % 2 == 1, then arr[i] = perm[n / 2 + (i - 1) / 2].
        
        def operate(nums):
            new_nums = nums.copy()
            for index, num in enumerate(nums):
                if index % 2 == 0:
                    new_nums[index] = nums[index // 2]
                else:
                    new_nums[index] = nums[n // 2 + (index - 1) // 2]
            # print(new_nums)
            return new_nums
        
        
        original_nums = [i for i in range(n)]
        
        curr = operate(original_nums)
        
                   
        ans = 1
        while curr != original_nums:
            curr = operate(curr)
            ans += 1
            
        return ans
        