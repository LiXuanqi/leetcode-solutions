/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        this.print(prev.next);
        ListNode secondHead = sortList(prev.next);
        prev.next = null;
        ListNode firstHead = sortList(dummy.next);
        return merge(firstHead, secondHead);
    }
    private ListNode merge(ListNode first, ListNode second) {
        if (first == null && second == null) {
            return null;
        }
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        while (first != null) {
            curr.next = first;
            first = first.next;
            curr = curr.next;
        }
        while (second != null) {
            curr.next = second;
            second = second.next;
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }
}