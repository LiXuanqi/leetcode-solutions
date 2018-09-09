/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null) {
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
                count++;
            }
            if (count == 1) {
                prev = prev.next;
                slow = slow.next;
            } else {
                prev.next = fast;
                slow = prev.next;
            }
            count = 0;
        }
        return dummy.next;
    }
}