from fractions import Fraction as F

class Solution:      
    def mirrorReflection(self, p: int, q: int) -> int:
        target = ((p, 0), (p, p), (0, p))
        x = 0
        y = 0
        rx = p
        ry = q 
        while (x, y) not in target:
            x, y = reflect(x, y, rx, ry, p)
            if x in (0, p):
                rx *= -1
            if y in (0, p):
                ry *= -1
        # print(x , y)
        return target.index((x, y))
              
def reflect(x, y, rx, ry, edge):
    candidate_times = []
    # find the smallest time = t
    # x + t * rx = 0 or edge
    candidate_times.append(F(-x, rx))
    candidate_times.append(F(edge - x, rx))
    # y + t * ry = 0 or edge
    candidate_times.append(F(-y, ry))
    candidate_times.append(F(edge - y, ry))
    
    smallest_time = min(filter(lambda time: time > 0,candidate_times))
    # print(candidate_times)
    return x + smallest_time * rx, y + smallest_time * ry

        
