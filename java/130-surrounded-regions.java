class Solution {
    int[] directionX = {0, 0, 1, -1};
    int[] directionY = {1, -1, 0, 0};
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 4 borders.
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        bfs(board, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void bfs(char[][] board, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        board[x][y] = 'B'; // Notice! if change the value when we poll out, one Point maybe put in the queue multiple times.
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + directionX[i];
                int nextY = curr.y + directionY[i];
                if (isValid(board, nextX, nextY) && board[nextX][nextY] == 'O') {
                    queue.offer(new Coordinate(nextX, nextY));
                    board[nextX][nextY] = 'B';
                }
            }
        }
    }
    private boolean isValid(char[][] board, int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
}