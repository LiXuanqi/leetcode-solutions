/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        //  null     1      2      3      4       5       null
        //  prev     curr    next
        //                                       prev     curr    next
        // why current != null not current.next != null.
        // it's ok, but note: now, the current.next = null, you should also make current.next = prev;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

//   1  ->  (  2   ->    3  ->    4  ->    5 )
// curr       next

//   1  ->  (  2   ->    3  ->    4  ->    5 )
//                                        curr       next