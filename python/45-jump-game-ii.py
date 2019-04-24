class Solution:
    def jump(self, nums: List[int]) -> int:
        if not nums:
            return -1
        jump = 0
        currFarest = 0
        currEnd = 0
        for i in range(len(nums) - 1):
            currFarest = max(currFarest, i + nums[i])
            if i == currEnd:
                jump += 1
                currEnd = currFarest
        return jump