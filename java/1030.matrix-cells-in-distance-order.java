class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        List<Coordinate> list = new ArrayList<>();
        Coordinate start = new Coordinate(r0, c0);
        // bfs
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.offer(start);
        visited[r0][c0] = true;
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            list.add(curr);
            // generate
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + directionX[i];
                int nextY = curr.y + directionY[i];
                if (isValid(nextX, nextY, visited) && !visited[nextX][nextY]) {
                    queue.offer(new Coordinate(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
        // System.out.println(list);
        int[][] ans = new int[R * C][2];
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            ans[count][0] = list.get(i).x;
            ans[count][1] = list.get(i).y;
            count++;
        }
        return ans;
    }
    private boolean isValid(int x, int y, boolean[][] visited) {
        return 0 <= x && x < visited.length && 0 <= y && y < visited[0].length;
    }
}