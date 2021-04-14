class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        nums = [float('inf')] + nums + [float('inf')]
        # 0 for even, 1 for odd
        ans = [0, 0]
        for index in range(1, len(nums) - 1):
            diff = nums[index] - min(nums[index - 1], nums[index + 1])
            if diff < 0:
                continue
            else:
                ans[index % 2] += (diff + 1)
        return min(ans)
                
        
