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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}

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
    long min = Long.MIN_VALUE;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        return ans;
    } 
    private void helper(TreeNode curr) {
        if (curr == null) {
            return;
        }
        helper(curr.left);
        if (curr.val <= min) {
            ans = false;
            return;
        }
        min = (long) curr.val;
        helper(curr.right);
    }
   
}