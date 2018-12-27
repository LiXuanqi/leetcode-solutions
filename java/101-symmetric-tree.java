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
  public boolean isSymmetric(TreeNode root) {
      if (root == null) {
          return true;
      }
      return symmetricHelper(root.left, root.right);
  }
  private boolean symmetricHelper(TreeNode node1, TreeNode node2) {
      if (node1 == null && node2 == null) {
          return true;
      }
      if (node1 == null || node2 == null) {
          return false;
      }
      if (node1.val != node2.val) {
          return false;
      }
      return symmetricHelper(node1.left, node2.right) && symmetricHelper(node1.right, node2.left);
  }
}
// Time = 4^log_2(n) = 2^2log_2(n) = 2^log_2(n^2) = O(n^2) (if balanced)
// Space = O(height of tree)