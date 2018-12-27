/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail) {

        if (head == tail) {
            return null;
        }
        // find mid.
        // 1    2   3   4   5   null
        //          s
        //                  f
        //          s
        //                  f
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode newHead = new TreeNode(slow.val);
        newHead.left = toBST(head, slow);
        newHead.right = toBST(slow.next, tail);
        
        return newHead;
    }
}