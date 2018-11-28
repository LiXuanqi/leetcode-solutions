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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null) {
            return null;
        }
        int length = pre.length - 1;
        return build(pre, post, 0, length, 0, length);
    }
    private TreeNode build(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if ((preStart > preEnd) || (postStart > postEnd)) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        TreeNode root = new TreeNode(pre[preStart]);
        // find left length;
        int leftStart = pre[preStart + 1];
        int leftLength = 0;
        
        while (post[postStart + leftLength] != leftStart) {
            leftLength++;
        }
        leftLength++;
        int rightLength = preEnd - preStart - leftLength;

        root.left = build(pre, post, preStart + 1, preStart + leftLength, postStart, postStart + leftLength - 1);
        root.right = build(pre, post, preStart + leftLength + 1, preEnd, postStart + leftLength, postEnd - 1);
        return root;
    }
}