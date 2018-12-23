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
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int rest = 0;
        while (pointer1 != null && pointer2 != null) {
            int sum = rest + pointer1.val + pointer2.val;
            rest = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        while (pointer1 != null) {
            int sum = rest + pointer1.val;
            rest = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            pointer1 = pointer1.next;
        }
        while (pointer2 != null) {
            int sum = rest + pointer2.val;
            rest = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            pointer2 = pointer2.next; 
        }
        if (rest != 0) {
            curr.next = new ListNode(rest);
        }
        return dummy.next;
    }
}