class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
           return true; 
        }
        // start from every postion in matrix.

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] used = new boolean[board.length][board[0].length];
                used[i][j] = true;
                if (search(board, word, 0, i, j, used)) {
                    return true;
                }
                used[i][j] = false;
            }
        }
        return false;
    }
    private boolean search(char[][] board, String word, int index, int startX, int startY, boolean[][] used) {
        if (index >= word.length()) {
            return true;    
        }
        
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};
        
        if (board[startX][startY] != word.charAt(index)) {
            return false;
        }
        
        if (index == word.length() - 1) {
            return true;
        }
        
        for (int i = 0; i < directionX.length; i++) {
            if (!isValid(board, startX + directionX[i], startY + directionY[i]) || used[startX + directionX[i]][startY + directionY[i]]) {
                continue;
            }
            used[startX + directionX[i]][startY + directionY[i]] = true;
            if (search(board, word, index + 1, startX + directionX[i], startY + directionY[i], used)) {
                return true;
            }
            used[startX + directionX[i]][startY + directionY[i]] = false;
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        int row = board.length - 1;
        int col = board[0].length - 1;
        return 0 <= x && x <= row && 0 <= y && y <= col;
    }
}