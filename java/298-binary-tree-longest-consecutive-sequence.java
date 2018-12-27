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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        
        if (root.left != null && root.left.val != root.val + 1) {
            left = 1;
        }
        if (root.right != null && root.right.val != root.val + 1) {
            right = 1;
        }
        
        int ans = Math.max(left, right);
        max = Math.max(ans, max);
  
        return ans;
    }
}