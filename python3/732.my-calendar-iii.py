# Solution 1: Sorted array
# Time: book - O(n)
START = 1
END = 0

class MyCalendarThree:

    def __init__(self):
        self.points = []
        

    def book(self, start: int, end: int) -> int:
        bisect.insort_right(self.points, (start, START))
        bisect.insort_right(self.points, (end, END))
        return self._get_max_overlap()
    
    def _get_max_overlap(self):
        
        ans = 0
        curr_overlap = 0
        for _, point_type in self.points:
            if point_type == START:
                curr_overlap += 1
            elif point_type == END:
                curr_overlap -= 1
          
            ans = max(ans, curr_overlap)
        return ans

# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(start,end)
