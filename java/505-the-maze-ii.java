class Solution {
     class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int minDist = Integer.MAX_VALUE;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            if (maze == null || maze.length == 0 || maze[0].length == 0 || start == null || start.length != 2 || destination == null || destination.length != 2) {
            return -1;
        }
        
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        
        int[][] distance = new int[maze.length][maze[0].length];
        // init with MAX_INTEGER
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(start[0], start[1]));
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            if (curr.x == destination[0] && curr.y == destination[1]) {
                minDist = Math.min(distance[curr.x][curr.y], minDist);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                // move to bound.
                int nextX = curr.x;
                int nextY = curr.y;
                int step = 0;
                while (isValid(maze, nextX + directionX[i], nextY + directionY[i]) && maze[nextX + directionX[i]][nextY + directionY[i]] == 0) {
                    nextX += directionX[i];
                    nextY += directionY[i];
                    step++;
                }
                if (distance[curr.x][curr.y] + step < distance[nextX][nextY]) {
                    queue.offer(new Coordinate(nextX, nextY));
                    distance[nextX][nextY] = distance[curr.x][curr.y] + step;
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    private boolean isValid(int[][] maze, int x, int y) {
        return 0 <= x && x < maze.length && 0 <= y && y < maze[0].length;
    }
}