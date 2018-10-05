class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(sr, sc));
        int flag = image[sr][sc];
        if (flag == newColor) {
            return image;
        }
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            image[curr.x][curr.y] = newColor;
            for (int i = 0; i < directionX.length; i++) {
                if (!isValid(image, curr.x + directionX[i], curr.y + directionY[i])) {
                    continue;
                }
                if (image[curr.x + directionX[i]][curr.y + directionY[i]] != flag) {
                    continue;
                }
                queue.offer(new Coordinate(curr.x + directionX[i], curr.y + directionY[i]));
            }
        }
        return image;
    }
    private boolean isValid(int[][] image, int x, int y) {
        return 0 <= x && x < image.length && 0 <= y && y < image[0].length;
    }
}