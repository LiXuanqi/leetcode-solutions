class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.EMPTY_LIST;
        }
        return printCircle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    private List<Integer> printCircle(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> ans = new ArrayList<>();
        if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                ans.add(matrix[startRow][i]);
            }
            return ans;
        }
        if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                ans.add(matrix[i][startCol]);
            }
            return ans;
        }
        // print circle.
        // top
        for (int i = startCol; i < endCol; i++) {
            ans.add(matrix[startRow][i]);
        }
        // right
        for (int i = startRow; i< endRow; i++) {
            ans.add(matrix[i][endCol]);
        }
        // down
        for (int i = endCol; i > startCol; i--) {
            ans.add(matrix[endRow][i]);
        }
        // left
        for (int i = endRow; i > startRow; i--) {
            ans.add(matrix[i][startCol]);
        }
        List<Integer> rest = printCircle(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1);
        ans.addAll(rest);
        return ans;
    }
}