class RLEIterator:

    def __init__(self, A: List[int]):
        self.A = list(reversed(A))
        

    def next(self, n: int) -> int:
        
        if not self.A:
            return -1
        
        while self.A and n > 0:
            num = self.A[-1]
            if n > num:
                n -= num
                self.A.pop()
                self.A.pop()
            else:
                self.A[-1] -= n
                ans = self.A[-2]
                n = 0
                if self.A[-1] == 0:
                    self.A.pop()
                    self.A.pop() 
                return ans
        
        return -1



# Your RLEIterator object will be instantiated and called as such:
# obj = RLEIterator(A)
# param_1 = obj.next(n)