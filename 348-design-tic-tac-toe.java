class TicTacToe {
    private int[][] matrix;
    private boolean isWin;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.matrix = new int[n][n];
        this.isWin = false;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (isWin) {
            return -1;
        }
        matrix[row][col] = player;
        if (checkWin(row, col)) {
            isWin = true;
            return matrix[row][col];
        }
        return 0;
    }
    private boolean checkWin(int x, int y) {
        int flag = matrix[x][y];
        int upDown = 0;
        int leftRight = 0;
        int leftUpRightDown = 0;
        int rightUpLeftDown = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[x][i] == flag) {
                leftRight++;
            }
            if (matrix[i][y] == flag) {
                upDown++;
            }
            if (matrix[i][i] == flag) {
                leftUpRightDown++;
            }
            if (matrix[i][matrix.length - 1 - i] == flag) {
                rightUpLeftDown++;
            }
        }       
            return leftRight == matrix.length || upDown == matrix.length || leftUpRightDown == matrix.length || rightUpLeftDown == matrix.length;
      
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */