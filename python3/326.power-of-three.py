from math import log

# Method 1:
class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        
        if n <= 0:
            return False

        return 3 ** round(log(n, 3)) == n
        
        

# Method 2：
class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0:
            return False
        
        right = find_upper_bound(n)
        
        return 3 ** right % n == 0
        
def find_upper_bound(num):
    base = 3
    factor = 1
    
    while base < num:
        base *= base
        factor *= 2
        
    return factor
