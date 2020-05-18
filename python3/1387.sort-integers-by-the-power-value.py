class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        ans = sorted(list(range(lo, hi+1)), key=get_power)
        return ans[k-1]
        
def get_power(num):
    ans = 0
    while num != 1:
        if num % 2 != 0:
            # odd
            num = 3 * num + 1
        else:
            # even
            num /= 2
        ans += 1
    return ans