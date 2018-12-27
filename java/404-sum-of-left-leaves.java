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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, false);
        return sum;
    }
    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                sum += root.val;
            }
            return;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }
}