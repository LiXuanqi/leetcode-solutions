/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
      ListNode dummy1 = new ListNode(0);
      ListNode dummy2 = new ListNode(0);
      ListNode tail1 = dummy1;
      ListNode tail2 = dummy2;
      while (head != null) {
          if (head.val < x) {
              tail1.next = head;
              head = head.next;
              tail1 = tail1.next;    
          } else {
              tail2.next = head;
              head = head.next;
              tail2 = tail2.next; 
          }
      }
      tail2.next = null; // note!
      tail1.next = dummy2.next;
      return dummy1.next;
  }
}