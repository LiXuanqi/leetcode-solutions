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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return ans - 1;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = helper(root.left);
        int rightLength = helper(root.right);
        if (root.left == null || root.left.val != root.val) {
            leftLength = 0;
        }
        if (root.right == null || root.right.val != root.val) {
            rightLength = 0;
        }
        ans = Math.max(ans, leftLength + rightLength + 1);
        return Math.max(leftLength, rightLength) + 1;
    }
}