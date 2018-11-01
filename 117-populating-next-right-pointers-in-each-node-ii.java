/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;
        TreeLinkNode prev = null;
        TreeLinkNode head = root;
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (prev == null) {
                        head = curr.left;
                        prev = curr.left;
                    } else {
                        prev.next = curr.left;
                        prev = curr.left;
                    }
                }
                if (curr.right != null) {
                    if (prev == null) {
                        head = curr.right;
                        prev = curr.right;
                    } else {
                        prev.next = curr.right;
                        prev = curr.right;
                    }
                }
                curr = curr.next;
            }
            curr = head;
            prev = null;
            head = null;
        }
    }
}