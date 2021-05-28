class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        dp = {0}
        for stone in stones:
            dp = {x + stone for x in dp} | {abs(x - stone) for x in dp}
        return min(dp)
    

        
