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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> solutions = new ArrayList<>();
      if (root == null) {
          return solutions;
      }
      dfs(root, solutions, new ArrayList<Integer>(), 0, sum);
      return solutions;
  }
  private void dfs(TreeNode root, List<List<Integer>> solutions, List<Integer> path, int sum, int target) {
      if (root == null) {
          return;
      }
      if (root.left == null && root.right == null) {
          if (sum + root.val == target) {
              path.add(root.val);
              solutions.add(new ArrayList<>(path));
              path.remove(path.size() - 1);
              return;
          }
      }
      path.add(root.val);
      dfs(root.left, solutions, path, sum + root.val, target);
      dfs(root.right, solutions, path, sum + root.val, target);
      path.remove(path.size() - 1);
  }
}