/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        int count = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + count;
            curr.next = new ListNode(sum % 10);
            count = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
            curr = curr.next;
        }
        while (head1 != null) {
            int sum = head1.val + count;
            curr.next = new ListNode(sum % 10);
            count = sum / 10;
            head1 = head1.next;
            curr = curr.next;
        }
        while (head2 != null) {
            int sum = head2.val + count;
            curr.next = new ListNode(sum % 10);
            count = sum / 10;
            head2 = head2.next;
            curr = curr.next;
        }
        if (count != 0) {
            curr.next = new ListNode(1);
        }
        return reverse(dummy.next);
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}