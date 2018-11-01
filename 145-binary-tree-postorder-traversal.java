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
        TreeNode prev = null;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();
            // go down
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                } else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    ans.add(curr.val);
                    stack.pollFirst();
                }   
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    ans.add(curr.val);
                    stack.pollFirst(); 
                }
            } else {
                 ans.add(curr.val);
                 stack.pollFirst(); 
            }
            prev = curr;
        }
        return ans;
    }
}