class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int row = 0;
        int col = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {
                if (col == matrix[0].length - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == matrix.length - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }

        }
        return result;
    }
}