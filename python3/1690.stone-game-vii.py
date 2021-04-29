# Solution 1:
class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        
        n = len(stones)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        prefix_sum = [0] * (n + 1)
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + stones[i]
            
        for length in range(2, n + 1):
            for left in range(n - length + 1):
                right = left + length - 1
                
                take_left =  prefix_sum[right + 1] - prefix_sum[left + 1] - dp[left + 1][right]
                take_right = prefix_sum[right] - prefix_sum[left] - dp[left][right - 1]
                
                # Bob decided to minimize the score's difference. 
                # Alice's goal is to maximize the difference in the score.
                dp[left][right] = max(take_left, take_right)
                    
             
        return dp[0][n - 1]

# Solution 2:
class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        FIRST = 0
        NOT_FIRST = 1

        n = len(stones)
        dp = [[[0] * 2 for _ in range(n)] for _ in range(n)]
        prefix_sum = [0] * (n + 1)
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + stones[i]
            
        for length in range(2, n + 1):
            for left in range(n - length + 1):
                right = left + length - 1
                
                take_left = dp[left + 1][right][NOT_FIRST] + prefix_sum[right + 1] - prefix_sum[left + 1]
                take_right = dp[left][right - 1][NOT_FIRST] + prefix_sum[right] - prefix_sum[left]
                
                # Bob decided to minimize the score's difference. 
                # Alice's goal is to maximize the difference in the score.
                if take_left - dp[left + 1][right][FIRST] > take_right - dp[left][right - 1][FIRST]:
                    dp[left][right][FIRST] = take_left
                    dp[left][right][NOT_FIRST] = dp[left + 1][right][FIRST]
                else:
                    dp[left][right][FIRST] = take_right
                    dp[left][right][NOT_FIRST] = dp[left][right - 1][FIRST]
                    
 
            
        return dp[0][n - 1][FIRST] - dp[0][n - 1][NOT_FIRST]
