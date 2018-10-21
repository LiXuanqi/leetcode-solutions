class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];
        int buildingNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(distance, grid, reach, i, j);
                    buildingNum++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE || min == 0 ? -1 : min;
    }
    private void bfs(int[][] distance, int[][] grid, int[][] reach, int x, int y) {
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        // bfs
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate curr = queue.poll();
                distance[curr.x][curr.y] += level;
                reach[curr.x][curr.y]++;
                for (int j = 0; j < 4; j++) {
                    int nextX = curr.x + directionX[j];
                    int nextY = curr.y + directionY[j];
                    if (isValid(nextX, nextY, grid) && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        queue.offer(new Coordinate(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
            level++;
        }
    }
    private boolean isValid(int x, int y, int[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
    
}