class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return false;
      }
      int height = matrix.length;
      int width = matrix[0].length;
      int start = 0;
      int end = height * width - 1;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          // m - col, n - row
          int n = mid / width;
          int m = mid % width;
          if (matrix[n][m] == target) {
              return true;
          } else if (matrix[n][m] < target) {
              start = mid;
          } else {
              end = mid;
          }
      }
      if (matrix[start / width][start % width] == target) {
          return true;
      }
      if (matrix[end / width][end % width] == target) {
          return true;
      }
      return false;
  }
}

// Time = O(log(m * n))
// Space = O(1)