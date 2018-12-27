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
  public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
          return false;
      }
      return dfs(root, 0, sum);
  }
  private boolean dfs(TreeNode root, int sum, int target) {
      if (root == null) {
          return false;
      }
      if (root.left == null && root.right == null) {
          return sum + root.val == target;
      }
      return dfs(root.left, sum + root.val, target) || dfs(root.right, sum + root.val, target);
      
  }
}