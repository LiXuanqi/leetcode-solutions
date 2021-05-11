class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        ans = 0
        previous = 0
        
        for num in target:
            if num > previous:
                ans += num - previous 
            previous = num
        return ans
        
