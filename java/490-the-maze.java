class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if (maze == null || maze.length == 0 || maze[0].length == 0 || start == null || destination == null || start.length != 2 || destination.length != 2) {
            return false;
        }
        
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        // try 4 directions
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if ((curr[0] == destination[0]) && (curr[1] == destination[1])) {
                return true;
            }
            // 4 directions
            for (int i = 0; i < 4; i++) {
                int x = curr[0];
                int y = curr[1];
                while (isValid(maze, x, y) && maze[x][y] == 0) {
                    x += directionX[i];
                    y += directionY[i];
                }
                if (isValid(maze, x - directionX[i], y - directionY[i]) && !visited[x - directionX[i]][y - directionY[i]]) {
                    queue.offer(new int[] {x - directionX[i], y - directionY[i]}); 
                    visited[x - directionX[i]][y - directionY[i]] = true;
                } 
            } 
        }
        return false;
    }
    private boolean isValid(int[][] maze, int x, int y) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }

}