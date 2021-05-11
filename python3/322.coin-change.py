class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        
        if not coins:
            return -1
        
        dp = [float('inf')] * (amount + 1)
        
        dp[0] = 0  
        
        for i in range(1, amount + 1):
            min_num = float('inf')
            for coin in coins:
                if i - coin >= 0:
                    
                    min_num = min(dp[i - coin], min_num)
                   
            dp[i] = min_num + 1        
         
        return dp[amount] if dp[amount] != float('inf') else -1
        
