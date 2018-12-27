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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode head = new TreeNode(preorder[preStart]);

        int currIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == head.val) {
                currIndex = i;
            }
        }
        head.left = build(preorder, inorder, preStart + 1, inStart, currIndex - 1);
        int leftLength = currIndex - inStart;
        head.right = build(preorder, inorder, preStart + leftLength + 1, currIndex + 1, inEnd);
        return head;
    }
}