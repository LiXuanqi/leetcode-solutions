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
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        getHeight(root, ans);

        return ans;
    }
    private int getHeight(TreeNode node, List<List<Integer>> list) {
        if (node == null) {
            return -1;
        }
        int left = getHeight(node.left, list);
        int right = getHeight(node.right, list);
        int height = Math.max(left, right) + 1;
        if (height >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(height).add(node.val);
        return height;
    }
}