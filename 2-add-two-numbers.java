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
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode curr = dummy;
        int count = 0;
        while (c1 != null && c2 != null) {
            int sum = c1.val + c2.val + count;
            count = sum / 10;
            sum %= 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            c1 = c1.next;
            c2 = c2.next;
        }
        while (c1 != null) {
            int sum = c1.val + count;
            count = sum / 10;
            sum %= 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            c1 = c1.next;
        }
        while (c2 != null) {
            int sum = c2.val + count;
            count = sum / 10;
            sum %= 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            c2 = c2.next;
        }
        if (count != 0) {
            curr.next = new ListNode(count);
        }
        return dummy.next;
    }
}