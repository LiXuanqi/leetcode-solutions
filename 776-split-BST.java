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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[] {null, null};
        }
        if (root.val == V) {
            TreeNode right = root.right;
            root.right = null;
            return new TreeNode[] {root, right}; 
        } else if (root.val < V) {
            TreeNode[] trees = splitBST(root.right, V);
            root.right = trees[0];
            return new TreeNode[] {root, trees[1]};
        } else {
            TreeNode[] trees = splitBST(root.left, V);
            root.left = trees[1];
            return new TreeNode[] {trees[0], root};
        }
        
    }
}