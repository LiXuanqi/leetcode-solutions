from collections import Counter
class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        # count
        counter = Counter(deck)
        minX = min(counter.values())
        maxX = max(counter.values())
        if minX <= 1:
            return False
        for x in range(2, minX + 1):
            if all([value % x == 0 for value in counter.values()]):
                return True
        return False