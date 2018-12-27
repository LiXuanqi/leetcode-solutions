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
      if (head == null || head.next == null) {
          return head;
      } 
      ListNode myHead = head;
      ListNode last = head.next; // find the first undepulicated node.
      while (last != null) {
          while (last !=null && myHead.val == last.val) {
              last = last.next;
          }
          myHead.next = last;
          if (last == null) {
            break;     
          }
          // when last == null, not move myHead and last.
          last = last.next;   
          myHead = myHead.next;
      }
      return head;
  }
}

// 1   1   2    3    3
//              h
//                        l
