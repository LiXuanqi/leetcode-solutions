class Solution {
    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] distance = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, distance, i, j));
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int[][] distance, int x, int y) {
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        if (distance[x][y] != 0) {
            return distance[x][y];
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + directionX[i];
            int nextY = y + directionY[i];
            if (!isValid(matrix, nextX, nextY) || matrix[nextX][nextY] >= matrix[x][y]) {
                continue;
            }
            distance[x][y] = Math.max(distance[x][y], dfs(matrix, distance, nextX, nextY));
        }
        distance[x][y]++;
        return distance[x][y];
    }
    private boolean isValid(int[][] matrix, int x, int y) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
}