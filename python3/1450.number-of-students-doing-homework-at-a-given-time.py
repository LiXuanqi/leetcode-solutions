class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        ans = 0
        for start, end in zip(startTime, endTime):
            if start <= queryTime <= end:
                ans += 1
        return ans
                
