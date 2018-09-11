/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode curr = head;
        ListNode oddCurr = oddDummy;
        ListNode evenCurr = evenDummy;
        int count = 1;
        while (curr != null) {
            if (count % 2 != 0) {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
            } else {
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
            }
            curr = curr.next;
            count++;
        }
        oddCurr.next = evenDummy.next;
        evenCurr.next = null;
        return oddDummy.next;
    }
}