class Solution:
    def new21Game(self, N: int, K: int, W: int) -> float:
        
        if K == 0 and N != 0:
            return 1
        
        if K + W - 1 <= N:
            return 1
        
        dp = [0] * (N + 1)
        dp[0] = 1
        
        
        window_sum = 1
        window_size = 1
        for i in range(1, N + 1):
            dp[i] = window_sum / W
            
            if i < K:
                window_sum += dp[i]
    
            if i - W >= 0:
                window_sum -= dp[i - W]
  
        return sum(dp[K:])
                
            
        
