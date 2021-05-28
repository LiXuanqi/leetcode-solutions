class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        intervals = []
        for index, r in enumerate(ranges):
            if r != 0:
                intervals.append((max(index - r, 0), min(index + r, n)))
            
        intervals.sort()
        
        ans = 0
        
        curr_end = 0
        candidates = []
        for interval in intervals:
            start, end = interval
            
            if start > curr_end:
                if not candidates:
                    return -1
                curr_end = max(candidates)
                ans += 1
                candidates = []
    
            if start <= curr_end:
                candidates.append(end)
            
        if candidates and curr_end != n:
            curr_end = max(candidates)
            ans += 1
            
        return ans if curr_end == n else -1
                            
            
        
