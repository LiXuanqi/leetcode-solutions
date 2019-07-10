class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!checkDiag(matrix, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkDiag(int[][] matrix,int startX, int startY) {
        int flag = matrix[startX][startY];
        while (startX < matrix.length && startY < matrix[0].length) {
            if (matrix[startX][startY] != flag) {
                return false;
            }
            startX++;
            startY++;
        }
        return true;
    }
}