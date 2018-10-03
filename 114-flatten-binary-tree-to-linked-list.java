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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenTreeAndReturnHead(root);
    }
    private TreeNode flattenTreeAndReturnHead(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftHead = flattenTreeAndReturnHead(root.left);
        TreeNode rightHead = flattenTreeAndReturnHead(root.right);
        TreeNode curr = root;
        root.left = null;
        if (leftHead != null) {
            curr.right = leftHead;
            // find the tail of left subtree.
            while (curr.right != null) {
                curr = curr.right;
            }
        }
        curr.right = rightHead;
        return root;
    }
}