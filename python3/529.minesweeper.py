MINE = 'M'
EMPTY = 'E'

BLANK = 'B'

DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0),
    (1, 1),
    (1, -1),
    (-1, -1),
    (-1, 1)
)

class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        def reveal(x, y):
            
            if board[x][y] == MINE:
                board[x][y] = 'X'
                return
            elif board[x][y] == EMPTY:
                mine_num = get_mines(x, y, board)
                if mine_num > 0:
                    board[x][y] = str(mine_num)
                    
                    return
                else:
                    board[x][y] = 'B'
                    
            for diff_x, diff_y in DIRECTIONS:
                next_x = x + diff_x
                next_y = y + diff_y
                if in_bound(next_x, next_y, board) and (board[next_x][next_y] == MINE or board[next_x][next_y] == EMPTY):
                    reveal(next_x, next_y)
                        
        reveal(click[0], click[1])
        return board
    
def in_bound(x, y, board):
    return 0 <= x < len(board) and 0 <= y < len(board[0])

def get_mines(x, y, board):
    return sum([
        1 
        for diff_x, diff_y in DIRECTIONS
        if in_bound(x + diff_x, y + diff_y, board) and board[x + diff_x][y + diff_y] == 'M'
    ])
