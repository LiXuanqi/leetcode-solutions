class MyCalendar:

    def __init__(self):
        self.root = None

    def book(self, start: int, end: int) -> bool:
        interval = Interval(start, end)
        if self.root is None:
            self.root = interval
            return True
        return self.root.insert(interval)
        
class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.left = None
        self.right = None
    def insert(self, interval):
        if self.end <= interval.start:
            if self.right is None:
                self.right = interval
                return True
            return self.right.insert(interval)
        elif self.start >= interval.end:
            if self.left is None:
                self.left = interval
                return True
            return self.left.insert(interval)
        else:
            return False

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)