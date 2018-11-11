class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return -1;
        }
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix[0].length - 1];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countSmallerOrEquals(matrix, mid) >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (countSmallerOrEquals(matrix, start) >= k) {
            return start;
        }
        return end;
    }
    private int countSmallerOrEquals(int[][] matrix, int target) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] <= target) {
                ans += matrix[0].length;
            } else {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] <= target) {
                        ans += 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
        
    }
}