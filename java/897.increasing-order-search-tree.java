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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dummy = new TreeNode(-1);
        curr = dummy;
        inorderTraversal(root);
        return dummy.right;
    }
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        inorderTraversal(root.right);
    }
}