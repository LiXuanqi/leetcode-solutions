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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left != null && t.right != null) {
            sb.append(String.format("(%s)(%s)", left, right));
        } else if (t.left == null && t.right == null) {
            return sb.toString();
        } else {
            if (t.left == null) {
                sb.append(String.format("()(%s)", right));
            }
            if (t.right == null) {
                sb.append(String.format("(%s)", left));
            }  
        }
        return sb.toString();
    }
}