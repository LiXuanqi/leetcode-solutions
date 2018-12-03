class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    // try 0 - 9
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            } 
                        }
                    }
                    return false; // 1 - 9 are all not invalid.
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int x, int y, char val) {
        for (int i = 0; i < board.length; i++) {
            // check row
            if (board[x][i] == val) {
                return false;
            }
            // check col
            if (board[i][y] == val) {
                return false;
            }
            if (!checkUnit(board, x, y, val)) {
                return false;
            }
        }
        return true;
    }
    private boolean checkUnit(char[][] board, int x, int y, char val) {
        int row = x / 3;
        int col = y / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row * 3 + i][col * 3 + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}