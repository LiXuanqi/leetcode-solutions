class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] directionX = {0, 0, 1, -1};
    int[] directionY = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                } 
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        grid[x][y] = '0';
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + directionX[i];
                int nextY = curr.y + directionY[i];
                if (inBound(nextX, nextY, grid) && grid[nextX][nextY] == '1') {
                    queue.offer(new Coordinate(nextX, nextY));
                    grid[nextX][nextY] = '0';
                }
            }
        }
    }
    private boolean inBound(int x, int y, char[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
}