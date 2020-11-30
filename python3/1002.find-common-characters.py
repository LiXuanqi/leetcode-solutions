from functools import reduce
from collections import Counter
class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        counters = [Counter(word) for word in A]
        common_character = reduce(lambda x, y : find_common_character(x, y), counters)
        ans = []
        for k, v in common_character.items():
            ans.extend([k] * v)
        return ans
        
def find_common_character(x, y):
    ans = {}
 
    for key in x.keys():
        if key in y:
            ans[key] = min(x[key], y[key])
    return ans
