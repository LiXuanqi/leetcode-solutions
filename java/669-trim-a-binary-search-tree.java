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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        if (L <= root.val && root.val <= R) {
            root.left = left;
            root.right = right;
            return root;
        } else {
            if (left == null && right == null) {
                return null;
            }
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
        }
        return null;
    }
}