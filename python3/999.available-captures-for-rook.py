DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        n, m = len(board), len(board[0])
        
        ans = 0
        
        for x in range(n):
            for y in range(m):
                if board[x][y] == 'R':
                    for direction in DIRECTIONS:
                        if can_capture(x, y, direction, board):
                            ans += 1
                            
        return ans
    
def can_capture(x, y, direction, board):
    while in_bound(x, y, board):
        if board[x][y] == 'p':
            return True
        elif board[x][y] == 'B':
            return False
        
        x += direction[0]
        y += direction[1]
        
    return False

def in_bound(x, y, board):
    n, m = len(board), len(board[0])
    return 0 <= x < n and 0 <= y < m
