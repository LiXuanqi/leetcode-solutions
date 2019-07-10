from collections import Counter
from functools import reduce
class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        # count
        counter = Counter(deck)
        return reduce(gcd, counter.values()) >= 2
def gcd(num1, num2):
    if num1 == 0:
        return num2
    return gcd(num2 % num1, num1)