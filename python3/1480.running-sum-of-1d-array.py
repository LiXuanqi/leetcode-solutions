class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        total = 0
        ans = []
        for num in nums:
            total += num
            ans.append(total)
        return ans
