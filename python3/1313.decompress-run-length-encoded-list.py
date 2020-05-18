class Solution:
    def decompressRLElist(self, nums: List[int]) -> List[int]:
        ans = []
        for index in range(0, len(nums), 2):
            freq = nums[index]
            val = nums[index + 1]
            ans.extend([val] * freq)
        return ans
        