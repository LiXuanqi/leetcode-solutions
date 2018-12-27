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
  public ListNode detectCycle(ListNode head) {
      if (head == null || head.next == null) {
          return null;
      }
      boolean isFirstTime = true;
      ListNode slow = head;
      // why fast = head not head.next ?  1  <====> 2   dead loop
      ListNode fast = head;
      while (isFirstTime || slow != fast) {
          isFirstTime = false;
          if (fast.next == null || fast.next.next == null) {
              return null;
          }
          slow = slow.next;
          fast = fast.next.next;
      }
      // find start position of loop.
      fast = head;
      while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
      }
      return slow;
  }
}
