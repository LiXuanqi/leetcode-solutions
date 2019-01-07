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
        char[][] ans = new char[board.length][board[0].length];
        for (char[] row : ans) {
            Arrays.fill(row, 'X');
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                bfs(board, ans, i, 0, visited);
            }
            if (board[i][board[0].length - 1] == 'O') {
                bfs(board, ans, i, board[0].length - 1, visited);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' ) {
                bfs(board, ans, 0, i, visited);
            }
            if (board[board.length - 1][i] == 'O') {
                bfs(board, ans, board.length - 1, i, visited);
            }
        }
        // copy back.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }
    private void bfs(char[][] board, char[][] ans, int x, int y, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            ans[curr.x][curr.y] = 'O';
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + directionX[i];
                int nextY = curr.y + directionY[i];
                if (isValid(board, nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] == 'O') {
                    queue.offer(new Coordinate(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
    private boolean isValid(char[][] board, int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
}