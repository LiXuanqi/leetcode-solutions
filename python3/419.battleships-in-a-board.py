class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        ans = 0
        
        for x, row in enumerate(board):
            for y, val in enumerate(row):
                if val == '.':
                    continue
                
                if x > 0 and board[x - 1][y] == 'X':
                    continue
                if y > 0 and board[x][y - 1] == 'X':
                    continue
                # only count top-left battleship
                ans += 1
                
        return ans
