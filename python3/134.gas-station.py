class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total = 0
        
        min_total = float('inf')
        min_index = -1
        
        for i in range(len(gas)):
            rest = gas[i] - cost[i]
            total += rest
            if total < min_total:
                min_index = i
                min_total = total
                
        return (min_index + 1) % len(gas) if total >= 0 else -1
        
        
