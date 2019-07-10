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
    TreeNode p1;
    TreeNode p2;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        // swap
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        
        if (prev != null && prev.val > root.val) {
            if (p1 == null) {
                p1 = prev;
                p2 = root;
            } else {
                p2 = root;
            } 
        }
        prev = root;
        
        if (root.right != null) {
            inorder(root.right);
        }
    }
}