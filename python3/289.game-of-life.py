class Solution:
    def gameOfLife(self, board: 'List[List[int]]') -> 'None':
        """
        Do not return anything, modify board in-place instead.
        """
        
        # -1 die
        # -2 live
        for x, row in enumerate(board):
            for y, val in enumerate(row):
                # print(board)
                lives = getAroundLives(board, x, y)
                # print("x=%d, y=%d, lives=%s" % (x, y, lives))
                if val == 1:
                    # <2 die
                    # 2 or 3 live
                    # >3 die  
                    if lives < 2 or lives > 3:
                        board[x][y] = -1
                elif val == 0:
                    # 3 live
                    if lives == 3:
                        board[x][y] = -2
        
        for x, row in enumerate(board):
            for y, val in enumerate(row):
                if val == -1:
                    board[x][y] = 0
                elif val == -2:
                    board[x][y] = 1
                    
        
directionX = [0, 0, 1, -1, 1, 1, -1, -1]
directionY = [1, -1, 0, 0, 1, -1, 1, -1]
        
def getAroundLives(board, x, y):
    count = 0
    
    def isValid(x, y):
        return 0 <= x < len(board) and 0 <= y < len(board[0])
    
    for diffX, diffY in zip(directionX, directionY):
        if isValid(x + diffX, y + diffY) and (board[x + diffX][y + diffY] == 1 or board[x + diffX][y + diffY] == -1) :
            # print(board[x + diffX][y + diffY])
            count += 1
    return count
              