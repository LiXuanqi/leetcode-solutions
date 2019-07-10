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
    int ans = 0;
    double minDiff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        findClosest(root, target);
        return ans;
    }
    private void findClosest(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        double diff = Math.abs(root.val - target);
        if (diff < minDiff) {
            ans = root.val;
            minDiff = diff;
        }
        if (root.val > target) {
            findClosest(root.left, target);
        }   
        if (root.val < target) {
            findClosest(root.right, target);
        }
    }
}