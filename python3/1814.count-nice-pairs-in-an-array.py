MOD = 10 ** 9 + 7

class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        rev_diff = collections.defaultdict(set)
        for index, num in enumerate(nums):
            diff = num - rev(num)
            rev_diff[diff].add(index)
        
        ans = 0
        
        for value in rev_diff.values():
            ans = (ans + math.comb(len(value), 2)) % MOD
            
        return ans
        
def rev(num):
    s = str(num)
    return int(s[::-1])
