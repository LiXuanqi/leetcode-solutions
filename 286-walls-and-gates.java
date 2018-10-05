class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        // find gate.
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                
                    fillEmpty(rooms, i, j);
                    
                }
            }
        }
    }
    private void fillEmpty(int[][] rooms, int x, int y) {
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        int level = 0;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate curr = queue.poll(); 
                if (rooms[curr.x][curr.y] != 0) {
                   rooms[curr.x][curr.y] = level; 
                }
                // expand
                for (int j = 0; j < 4; j++) {
                    int nextX = curr.x + directionX[j];
                    int nextY = curr.y + directionY[j];
                    if (!isValid(rooms, nextX, nextY)) {
                        continue;
                    }
                    // wall
                    if (rooms[nextX][nextY] == -1) {
                        continue;
                    }
                    // gate
                    if (rooms[nextX][nextY] == 0) {
                        continue;
                    }
                    if (rooms[nextX][nextY] < level + 1) {
                        continue;
                    }
                    queue.offer(new Coordinate(nextX, nextY));
                }
            }
            level++;
        }
    }
    private boolean isValid(int[][] rooms, int x, int y) {
        return 0 <= x && 0 <= y && x < rooms.length && y < rooms[0].length;
    }
}