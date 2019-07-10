/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // find middle
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;   
            }  
        }
        prev.next = null;
        // reverse the second half of linked list.
        ListNode secondHead = reverse(slow, fast);
        ListNode firstHead = dummy.next;

        dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (firstHead != null && secondHead != null) {
            tail.next = firstHead;
            firstHead = firstHead.next;
            tail = tail.next;
            tail.next = secondHead;
            secondHead = secondHead.next;
            tail = tail.next;
        }
        if (firstHead != null) {
            tail.next = firstHead;
            firstHead = firstHead.next;
            tail = tail.next;
        }
        if (secondHead != null) {
            tail.next = secondHead;
            secondHead = secondHead.next;
            tail = tail.next;
        }
        tail.next = null;
        head = dummy.next;
    }
    private ListNode reverse(ListNode slow, ListNode fast) {
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return fast;
    }
}