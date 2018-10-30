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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode build(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        if (start > end) {
            return null;
        }
        // find max;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = build(nums, start, maxIndex - 1);
        node.right = build(nums, maxIndex + 1, end);
        return node;
    }
}