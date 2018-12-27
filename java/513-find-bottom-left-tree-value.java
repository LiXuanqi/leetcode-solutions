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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            ans = curr.val;
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
        }
        return ans;
    }
}