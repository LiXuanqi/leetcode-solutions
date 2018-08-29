/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode myHead = head.next;
        head.next = swapPairs(myHead.next);
        myHead.next = head;
        return myHead;
    }
}

// Time = O(n)
// Space = O(1)