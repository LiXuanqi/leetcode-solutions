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
  public int minDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      int level = 0;
      while (!queue.isEmpty()) {
          int size = queue.size();
          level++;
          for (int i = 0; i < size; i++) {
              
              TreeNode node = queue.poll();
              if (node.left != null) {
                  queue.offer(node.left);
              }
              if (node.right != null) {
                  queue.offer(node.right);
              }
              if (node.left == null && node.right == null) {
                  return level;
              }
          }
      }
      return level;
  }
}

// Time = O(n)
// Space = O(n)

// TODO: recursion