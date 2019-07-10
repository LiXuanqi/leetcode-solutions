class Solution {
    public void rotate(int[][] matrix) {
        rotateMatrix(matrix, 0, matrix.length - 1);
    }
    private void rotateMatrix(int[][] matrix, int leftUp, int rightDown) {
        if (leftUp >= rightDown) {
            return;
        }
        int length = rightDown - leftUp + 1;
        int[] temp = new int[length];
        // store temp
        for (int i = 0; i < length; i++) {
            temp[i] = matrix[leftUp][leftUp + i];
        }
        // left to up
        for (int i = 0; i < length; i++) {
            matrix[leftUp][leftUp + i] = matrix[rightDown - i][leftUp];
        }
        // down to left
        for (int i = 0; i < length; i++) {
            matrix[leftUp + i][leftUp] = matrix[rightDown][leftUp + i];
        }
        // right to down
        for (int i = 0; i < length; i++) {
            matrix[rightDown][leftUp + i] = matrix[rightDown - i][rightDown];
        }
        // temp to right
        for (int i = 0; i < length; i++) {
            matrix[leftUp + i][rightDown] = temp[i];
        }
        rotateMatrix(matrix, leftUp + 1, rightDown - 1);
    }
}