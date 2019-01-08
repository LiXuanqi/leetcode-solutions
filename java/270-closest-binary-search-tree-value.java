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
    public int closestValue(TreeNode root, double target) {
        double minDiff = Double.MAX_VALUE;
        int ans = root.val;
        while (root != null) {
            double diff = Math.abs(root.val - target);
            if (diff < minDiff) {
                minDiff = diff;
                ans = root.val;
            }
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }
}