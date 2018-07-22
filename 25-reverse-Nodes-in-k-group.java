/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
      int count = 0;
      ListNode curr = head;
      while (curr != null && count != k) {
          curr = curr.next;
          count++;
      }
      if (count == k) {
          ListNode prev = reverseKGroup(curr, k);
          curr = head;
          while (count > 0) {
              ListNode next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
              count--;
          }
          return prev;
      } else {
          return head;
      }
  }
}