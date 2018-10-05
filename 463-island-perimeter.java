class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // find island.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return iterateIslands(grid, i, j);
                }
            }
        }
        return 0;
    }
    private int iterateIslands(int[][] grid, int x, int y) {
        int sum = 0;
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            int edge = getEdges(grid, curr.x, curr.y);
            sum += edge;
            // expand 4 directions
            for (int i = 0; i < directionX.length; i++) {
                if (!isValid(grid, curr.x + directionX[i], curr.y + directionY[i])) {
                    continue;
                }
                if (grid[curr.x + directionX[i]][curr.y + directionY[i]] != 1) {
                    continue;
                }

                if (visited[curr.x + directionX[i]][curr.y + directionY[i]]) {
                    continue;
                }
                queue.offer(new Coordinate(curr.x + directionX[i], curr.y + directionY[i]));
                visited[curr.x + directionX[i]][curr.y + directionY[i]] = true;
            }
        }
        return sum;
    }
    private int getEdges(int[][] grid, int x, int y) {
        
        int edges = 0;
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        for (int i = 0; i < directionX.length; i++) {
            if (!isValid(grid, x + directionX[i], y + directionY[i])) {
                edges++;
                continue;
            }
            edges += grid[x + directionX[i]][y + directionY[i]] == 1 ? 0 : 1;
        }
        // System.out.println("x: " + x + " y: " + y + " edge: " + edges);
        return edges;
    }
    private boolean isValid(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}