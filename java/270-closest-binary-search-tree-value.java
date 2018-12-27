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
    int result;
    double diff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (Math.abs(curr.val - target) < diff) {
                diff = Math.abs(curr.val - target);
                result = curr.val;
            }
            if (curr.val > target) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return result;
    }
}