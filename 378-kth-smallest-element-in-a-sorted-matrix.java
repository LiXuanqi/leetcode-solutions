class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        PriorityQueue<Coordinate> heap = new PriorityQueue<>((c1, c2) -> {
            return Integer.compare(matrix[c1.x][c1.y], matrix[c2.x][c2.y]);
        });
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        heap.offer(new Coordinate(0, 0));
        used[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Coordinate curr = heap.poll();
            // right
            Coordinate right = new Coordinate(curr.x, curr.y + 1);
            if (isValid(right, matrix) && !used[right.x][right.y]) {
                heap.offer(right);
                used[right.x][right.y] = true;
            }
            // bottom
            Coordinate bottom = new Coordinate(curr.x + 1, curr.y);
            if (isValid(bottom, matrix) && !used[bottom.x][bottom.y]) {
                heap.offer(bottom);
                used[bottom.x][bottom.y] = true;
            }
        }
        Coordinate ans = heap.peek();
        return matrix[ans.x][ans.y];
    }
    private boolean isValid(Coordinate c, int[][] matrix) {
        return 0 <= c.x && c.x < matrix.length && 0 <= c.y && c.y < matrix[0].length;
    }
}