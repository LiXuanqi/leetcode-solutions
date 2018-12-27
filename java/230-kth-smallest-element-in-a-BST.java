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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        TreeNode helper = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || helper != null) {
            while (helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            }
            TreeNode curr = stack.pollFirst();
            count++;
            if (count == k) {
                return curr.val;
            }
            if (curr.right != null) {
                helper = curr.right;
            }
        }
        return -1;
    }
}