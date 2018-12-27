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
  private int result = 0;
  public int pathSum(TreeNode root, int sum) {
      if (root == null) {
          return result;
      }
      Set<Integer> set = new HashSet<>();
      set.add(0);
      dfs(root, set, 0, sum);
      return result;
  }
  private void dfs(TreeNode root, Set<Integer> set, int sum, int target) {
      if (root == null) {
          return;
      }
      if (set.contains(root.val + sum - target)) {     
          if (root.val + sum == target) {
              result++;
          }
          result++;
      }
      // if (root.left == null && root.right == null) {
      //     if (sum + root.val == target) {
      //         result++;
      //         return;
      //     }
      // }
      set.add(sum + root.val);
      dfs(root.left, set, sum + root.val, target);
      dfs(root.right, set, sum + root.val, target);
      // if (sum + root.val != 0) {
      //    set.remove(sum + root.val); 
      // }
  }
}