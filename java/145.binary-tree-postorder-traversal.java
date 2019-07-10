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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                // go down
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    ans.add(stack.pop().val);
                }
            } else if (curr.left == prev) {
                // from left subtree
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    ans.add(stack.pop().val);
                }
            } else {
                // from right subtree
                ans.add(stack.pop().val);
            }
            prev = curr;
        }
        return ans;
    }
}