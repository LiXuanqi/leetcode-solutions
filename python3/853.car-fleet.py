class Solution:
    def carFleet(self, target: int, positions: List[int], speeds: List[int]) -> int:
        cars = sorted(zip(positions, speeds))
        times = [(target - position) / speed for position, speed in cars]
        ans = 0
        while len(times) > 1:
            rightmost_car_time = times.pop()
            if rightmost_car_time < times[-1]:
                ans += 1
            else:
                times[-1] = rightmost_car_time
        
            
        return ans + (1 if times else 0)
            
        