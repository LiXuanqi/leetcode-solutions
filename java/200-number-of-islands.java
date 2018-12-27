class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int count = 0;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findIsland(grid, i, j);
                }
            }
        }
        return count;
    }
    private void findIsland(char[][] grid, int startX, int startY) {
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        count++;
        queue.offer(new Coordinate(startX, startY));
        grid[startX][startY] = '0';
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
           
            // expand
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + directionX[i];
                int nextY = curr.y + directionY[i];
                if (!isValid(grid, nextX, nextY)) {
                    continue;
                }
                if (grid[nextX][nextY] != '1') {
                    continue;
                }
                queue.offer(new Coordinate(nextX, nextY));
                grid[nextX][nextY] = '0';
            }
        }
    }
    private boolean isValid(char[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}