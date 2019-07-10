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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // find target
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
 
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);

        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode smallest = findAndDeleteSmallest(root.right);
                smallest.right = root.right;
                smallest.left = root.left;
                return smallest;
            }
        }
        return root;
    }
    private TreeNode findAndDeleteSmallest(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = curr;
        curr = curr.left;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        prev.left = prev.left.right;
        return curr;
    }
}