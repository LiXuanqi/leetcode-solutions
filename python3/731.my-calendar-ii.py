BEGIN = 1
END = 0

class MyCalendarTwo:

    def __init__(self):
        
        self.events = {}
        self.start_points = []
        self.end_points = []
        self.id = 0
        

    def book(self, start: int, end: int) -> bool: 

        overlap_events = self._search_start(end, self.start_points) & self._search_end(start, self.end_points)
        if not self.is_valid(overlap_events, start, end):
            return False
        
        self._insert_events((start, self.id), self.start_points)
        self._insert_events((end, self.id), self.end_points)
        self.events[self.id] = (start, end)
        self.id += 1
        return True
    
    def _search_start(self, end, points):
        # Assume points is ordered.
        events = set()
   
        index = bisect.bisect_left([point[0] for point in points], end)
        
        if index < len(points) and points[index][0] == end:
            return set(event for _, event in points[:index])
        return set(event for _, event in points[:index + 1])



        return set()
        
    def _search_end(self, start, points):
         # Assume points is ordered.
        events = set()

        index = bisect.bisect_right([point[0] for point in points], start)

        if index < len(points) and points[index][0] == start:
            return set(event for _, event in points[index + 1:])
        return set(event for _, event in points[index:])
            
       
    
    def _insert_events(self, event, points):
        bisect.insort_left(points, event)
        
    def is_valid(self, event_ids, start, end):
       
        events = [self.events[event_id] for event_id in event_ids]
        events.append((start, end))

        points = []
        
        for start, end in events:
            points.append((start, BEGIN))
            points.append((end, END))
        points.sort()
        count = 0 
   
        for point, point_type in points:
            if point_type == BEGIN:
                count += 1
            elif point_type == END:
                count -= 1
            
            if count >= 3:
                return False
        return True

# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)
