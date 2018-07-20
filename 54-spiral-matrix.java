class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
      if (matrix == null) {
          return null;
      }
      if (matrix.length == 0 || matrix[0].length == 0) {
          return new ArrayList<Integer>();
      }
      return printSpiralCircle(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
  }
  private List<Integer> printSpiralCircle(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
      List<Integer> level = new ArrayList<>();
      if (startRow > endRow || startCol > endCol) {
          return level;
      }
      if (startRow == endRow) {
          for (int i = startCol; i <= endCol; i++) {
              level.add(matrix[startRow][i]);
          }
          return level;
      }
      if (startCol == endCol) {
          for (int i = startRow; i <= endRow; i++) {
              level.add(matrix[i][startCol]);
          }
          return level;
      }
      for (int i = startCol; i < endCol; i++) {
          level.add(matrix[startRow][i]);
      }
      for (int i = startRow; i < endRow; i++) {
          level.add(matrix[i][endCol]);
      }
      for (int i = endCol; i > startCol; i--) {
          level.add(matrix[endRow][i]);
      }
      for (int i = endRow; i > startRow; i--) {
          level.add(matrix[i][startCol]);
      }
      level.addAll(printSpiralCircle(matrix, startRow + 1, startCol + 1,  endRow - 1, endCol - 1));
      return level;
  }
}
