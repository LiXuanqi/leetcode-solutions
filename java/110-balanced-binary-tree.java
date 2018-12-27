/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public boolean isBalanced(TreeNode root) {
      if (root == null) {
          return true;
      }
      return getHeight(root) == -1 ? false : true;
  }
  private int getHeight(TreeNode root) {
      if (root == null) {
          return 0;
      }
      int left = getHeight(root.left);
      int right = getHeight(root.right);
      if (left < 0 || right < 0) {
          return -1;
      }
      return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
  }
}