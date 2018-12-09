/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        return build(0, 0, grid.length - 1, grid.length - 1, grid);
    }
    private Node build(int row1, int col1, int row2, int col2, int[][] grid) {
        if (row1 > row2 || col1 > col2) {
            return null;
        }
        boolean isLeaf = true;
        int val = grid[row1][col1];
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        }
        int rowMid = (row1 + row2) / 2;
        int colMid = (col1 + col2) / 2;
        return new Node(
            false,
            false,
            build(row1, col1, rowMid, colMid, grid),
            build(row1, colMid + 1, rowMid, col2, grid),
            build(rowMid + 1, col1, row2, colMid, grid),
            build(rowMid + 1, colMid + 1, row2, col2, grid)
        );
    }
}