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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
   
        TreeNode help = root;
        while (help != null || !stack.isEmpty()) {
            while (help != null) {
                stack.offerFirst(help);
                help = help.left;
            }
            TreeNode node = stack.pollFirst();
            result.add(node.val);
            help = node.right;
        }
        return result;
    }
}