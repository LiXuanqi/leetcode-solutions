class Solution:
    def secondHighest(self, s: str) -> int:
        counts = [0] * 10
        for c in s:
            if c.isdigit():
                counts[int(c)] += 1
        found_largest = False
        for i in range(9, -1, -1):
            if counts[i] != 0:
                if found_largest:
                    return i
                found_largest = True
        return -1
        
