class ExamRoom:

    def __init__(self, N: int):
        self.N = N
        self.priority_queue = [(self._dist(-1, N), -1, N)]
        
        

    def seat(self) -> int:
        _, start, end = heapq.heappop(self.priority_queue)
        if start == -1:
            mid = 0
        elif end == self.N:
            mid = self.N - 1
        else:
            mid = (end + start) // 2
        heapq.heappush(self.priority_queue, (self._dist(start, mid), start, mid))
        heapq.heappush(self.priority_queue, (self._dist(mid, end), mid, end))
        return mid
        

    def leave(self, p: int) -> None:
    
        front_seat = behind_seat = None
        for seat_info in self.priority_queue:
            _, start, end = seat_info
            if end == p:
                front_seat = seat_info
            if start == p:
                behind_seat = seat_info
            if front_seat and behind_seat:
                break
  
        self.priority_queue.remove(front_seat)
        self.priority_queue.remove(behind_seat)
        new_start, new_end = front_seat[1], behind_seat[2]
        self.priority_queue.append((self._dist(new_start, new_end), new_start, new_end))
        heapq.heapify(self.priority_queue)
        
        
    
    def _dist(self, left, right):
        if left == -1:
            return -right
        if right == self.N:
            return -(self.N - 1 - left)
        return -((right - left) // 2)
        


# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(N)
# param_1 = obj.seat()
# obj.leave(p)