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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd) {
        if (postStart >= postorder.length || inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        // find root;
        int rootIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postStart]) {
                rootIndex = i;
            }
        }
        root.left = build(inorder, postorder, postStart - (inEnd - rootIndex) - 1, inStart, rootIndex - 1);
        root.right = build(inorder, postorder, postStart - 1, rootIndex + 1, inEnd);
        return root;
    }
}