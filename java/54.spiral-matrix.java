class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.EMPTY_LIST;
        }
        return printCircle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    private List<Integer> printCircle(int[][] matrix, int startX, int startY, int endX, int endY) {
        List<Integer> ans = new ArrayList<>();
        if (startX > endX || startY > endY) {
            return ans;
        }
        if (startX == endX) {
            for (int i = startY; i <= endY; i++) {
                ans.add(matrix[startX][i]);
            }
            return ans;
        }
        if (startY == endY) {
            for (int i = startX; i <= endX; i++) {
                ans.add(matrix[i][startY]);
            }
             return ans;
        }
        // top
        for (int i = startY; i < endY; i++) {
            ans.add(matrix[startX][i]);
        }
        // right
        for (int i = startX; i < endX; i++) {
            ans.add(matrix[i][endY]);
        }
        // down
        for (int i = endY; i > startY; i--) {
            ans.add(matrix[endX][i]);
        }
        // left
        for (int i = endX; i > startX; i--) {
            ans.add(matrix[i][startY]);
        }
        ans.addAll(printCircle(matrix, startX + 1, startY + 1, endX - 1, endY - 1));
        return ans;
    }
}