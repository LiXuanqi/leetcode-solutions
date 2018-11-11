class Solution {
    private int ans = 0;
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                }
            }
        }
        return ans;
    }
    private void bfs(int[][] grid, int x, int y, boolean[][] visited) {
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        int num = 0;
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            // System.out.println(String.format("x=%d,y=%d", curr.x, curr.y));
            num++;
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + directionX[i];
                int nextY = curr.y + directionY[i];
                // System.out.println(String.format("nextX=%d,nextY=%d", nextX, nextY));
                if (isValid(grid, nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.offer(new Coordinate(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            } 
        }
        // System.out.println(num);
        ans = Math.max(ans, num);
        
    }
    private boolean isValid(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}