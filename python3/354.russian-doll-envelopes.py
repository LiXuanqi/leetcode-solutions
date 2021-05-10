class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda envelope: (envelope[0], -envelope[1]))
        
        return LIS([h for _, h in envelopes])
        
        
def LIS(nums):
    tails = []
    for num in nums:
        index = bisect.bisect_left(tails, num)

        if index == len(tails):
            tails.append(num)
        else:
            tails[index] = num
    return len(tails)
