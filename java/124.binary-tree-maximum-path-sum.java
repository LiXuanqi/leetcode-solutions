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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum(root);
        return result;
    }
    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxSum(root.left), 0);
        int right = Math.max(maxSum(root.right), 0);
        int sum = left + right + root.val;
        result = Math.max(sum, result);
        return root.val + Math.max(left, right);
    }
}