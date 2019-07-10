/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }    
        ListNode slow = head;
        ListNode fast = head;
        // move n step
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head) {
            return head.next;
        }
        // delete node
        prev.next = slow.next;
        slow.next = null;
        return head;
    }
}