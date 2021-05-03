FIRST = 0
NOT_FIRST = 1

class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        
        dp = [[None for _ in range(2)] for _ in range(n + 1)]
        
        dp[0][FIRST] = False
        dp[0][NOT_FIRST] = True
        
        for num in range(1, n + 1):
            square_num = num * num
            if square_num> n:
                break
            
            dp[square_num][FIRST] = True
            dp[square_num][NOT_FIRST] = False
        
        
        for i in range(2, n + 1):
            
            can_win = False
            
            for try_num in range(1, n):
                if try_num * try_num > i:
                    break
                
                if dp[i - try_num * try_num][NOT_FIRST]:
                    can_win = True
                    break
                    
           
                    
            dp[i][FIRST] = can_win
            dp[i][NOT_FIRST] = not can_win
            
       
        
        return dp[n][FIRST]
