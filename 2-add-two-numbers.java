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
      ListNode dummy = new ListNode(0);
      ListNode p = l1;
      ListNode q = l2;
      ListNode curr = dummy;
      int counter = 0;
      while (p != null || q != null) {
          int x = p != null ? p.val : 0;
          int y = q != null ? q.val : 0;
          int sum = x + y + counter;
          counter = sum / 10;
          curr.next = new ListNode(sum % 10);
          curr = curr.next;
          p = p != null ? p.next : null;
          q = q != null ? q.next : null;
      }
      if (counter != 0) {
          curr.next = new ListNode(counter);
          curr = curr.next;
      }
      curr.next = null;
      return dummy.next;
  }
}