/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        int count = 1;
        ListNode curr = head;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        // create a circle.
        curr.next = head;
        k = k % count;
        int offset = count - k - 1;
        curr = head;
        while (offset > 0) {
            curr = curr.next; 
            offset--;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}