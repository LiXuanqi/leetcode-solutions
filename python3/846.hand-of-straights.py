class Solution:
    def isNStraightHand(self, hand: List[int], W: int) -> bool:
        counter  = collections.Counter(hand)
        
        starts = collections.deque()
        opened = 0
        last_check = -1
        
        for i in sorted(counter.keys()):
            if opened > counter[i]:
                return False
            if opened > 0 and i > last_check + 1:
                return False
            
            starts.append(counter[i] - opened)
            last_check = i
            opened = counter[i]
            if len(starts) == W:
                opened -= starts.popleft()
                
        return opened == 0