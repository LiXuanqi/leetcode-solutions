class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 1:
            return nums[0]
        candidate1 = rangeRob(nums, 0, len(nums) - 2)
        candidate2 = rangeRob(nums, 1, len(nums) - 1)
        return max(candidate1, candidate2)
def rangeRob(nums, low, high):
    rob = 0
    notRob = 0
    for i in range(low, high + 1):
        lastRob = rob
        lastNotRob = notRob
        rob = lastNotRob + nums[i]
        notRob = max(lastRob, lastNotRob)
    return max(rob, notRob)