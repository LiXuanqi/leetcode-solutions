/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            while (next != null && m != 1) {
                prev = prev.next;
                curr = curr.next;
                next = next.next;
                m--;
                n--;
            }
            ListNode oldPrev = prev;
            ListNode tail = curr;
            while (next != null && n != 1) {
                ListNode nextAfterNext = next.next;
                next.next = curr;
                prev = curr;
                curr = next;
                next = nextAfterNext;
                n--;
            }
            oldPrev.next = curr;
            tail.next = next;
            break;
        }
        return dummy.next;
    }
}