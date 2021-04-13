class Solution:
    def canTransform(self, start: str, end: str) -> bool:
        if start.count('X') != end.count('X'):
            return False
        i = 0
        j = 0
        while i < len(start) and j < len(end):
            while i < len(start) and start[i] == 'X':
                i += 1
            while j < len(end) and end[j] == 'X':
                j += 1
                
            if i == len(start) or j == len(start):
                return i == j
            
            if start[i] != end[j]:
                # The order of 'L' and 'R' can't change
                return False
            if start[i] == 'L' and i < j:
                # L can only go left
                return False
            if start[i] == 'R' and i > j:
                # R can only go right
                return False
            i += 1
            j += 1
        return True
                
        
