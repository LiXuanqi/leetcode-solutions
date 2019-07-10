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
    public TreeNode pruneTree(TreeNode root) {
        hasOneAndPrune(root);
        return root;
    }
    private boolean hasOneAndPrune(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean leftHasOne = hasOneAndPrune(root.left);
        boolean rightHasOne = hasOneAndPrune(root.right);
        if (!leftHasOne) {
            root.left = null;
        }
        if (!rightHasOne) {
            root.right = null;
        }
        if (root.val == 1) {
      
            return true;
        } else {
           
            return leftHasOne || rightHasOne;
        }
    }
}