class RangeModule:

    def __init__(self):
        self.points = []
        

    def addRange(self, left: int, right: int) -> None:
        if not self.points:
            self.points.append(left)
            self.points.append(right)
        else:

            start = bisect.bisect_left(self.points, left) - 1
            end = bisect.bisect_right(self.points, right)
            
            sub_array = []
            
            if not is_start(start):
                sub_array.append(left)
                
            if is_start(end):
                sub_array.append(right)
                
            self.points[start + 1: end] = sub_array

                
            
        

    def queryRange(self, left: int, right: int) -> bool:
     
        if not self.points:
            return False

        start = bisect.bisect_right(self.points, left)
        end = bisect.bisect_left(self.points, right)
     
        return start == end and is_start(start - 1)

    def removeRange(self, left: int, right: int) -> None:
        if not self.points:
            return
        
        start = bisect.bisect_left(self.points, left) - 1
        end = bisect.bisect_right(self.points, right)
        # print(start, end)
        sub_array = []
        
        if is_start(start):
            sub_array.append(left)
            
        if not is_start(end):   
            sub_array.append(right)
        
        self.points[start + 1: end] = sub_array
        
    
def is_start(n):
    return n % 2 == 0
        


# Your RangeModule object will be instantiated and called as such:
# obj = RangeModule()
# obj.addRange(left,right)
# param_2 = obj.queryRange(left,right)
# obj.removeRange(left,right)
