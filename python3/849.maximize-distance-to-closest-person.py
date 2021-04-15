class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        n = len(seats)
        seats = [index for index, val in enumerate(seats) if val == 1]
        seats = [-1] + seats + [n]
        
        # print(seats)
        
        def dist(start, end):
            if start == -1:
                return end
            if end == n:
                return n - 1 - start
            return (end - start) // 2
        
        max_dist = float('-inf')
        for seat_1, seat_2 in zip(seats, seats[1:]):
            max_dist = max(max_dist, dist(seat_1, seat_2))
            
        return max_dist
        