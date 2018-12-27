/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) {
          return false;
      }
      ListNode slow = head;
      ListNode fast = head.next;
      while (slow != fast) {
          // slow must be slower than fast, so there is no need to check the slow.next != null.
          if (fast.next == null || fast.next.next == null) {
              return false;
          }
          slow = slow.next;
          fast = fast.next.next;
      }
      return true;
  }
}