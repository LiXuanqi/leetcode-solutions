/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Method 1: inorder traversal
class Solution {
    Integer prev = null;
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        inorderTraverse(root);
        return ans;
    }
    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        if (prev == null) {
            prev = root.val;
        } else {
            int diff = root.val - prev;
            ans = Math.min(diff, ans);
            prev = root.val;
        }
        
        inorderTraverse(root.right);
    }
}
// Method 2: without recurssion
class Solution {
    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        if (root == null) {
            return -1;
        }
        long prev = Long.MIN_VALUE;
        TreeNode helper = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || helper != null) {
            while (helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            }
            TreeNode curr = stack.pollFirst();
            // System.out.println(curr.val);
            if (prev == Long.MIN_VALUE) {
                prev = curr.val;
            } else {
                int diff = curr.val - (int) prev;
                prev = curr.val;
                minDiff = Math.min(minDiff, diff);      
            }     
            if (curr.right != null) {
                helper = curr.right;
            }
        }
        return minDiff;
    }
}