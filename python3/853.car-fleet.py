class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        
        cars = list(zip(position, speed))
        cars.sort()
        
        # iterate from tail
        stack = []
        
        i = len(cars) - 1
        while i >= 0:
            curr_car = cars[i]
            
            if not stack or not will_collision(curr_car, stack[-1], target):
                stack.append(curr_car)
            
            i -= 1
            
        return len(stack)
    
def will_collision(first_car, second_car, total_distance):
    if first_car[1] <= second_car[1]:
        return False
    possible_collision_time = (second_car[0] - first_car[0]) / (first_car[1] - second_car[1])
    second_arrive_time = (total_distance - second_car[0]) / second_car[1]
    return second_arrive_time >= possible_collision_time
            
