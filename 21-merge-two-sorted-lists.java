/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next; 
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next; 
        }
        while (l2 != null) {
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
        }
        tail.next = null;
        return dummy.next;
    }
}

// 1   ->     2    ->     4

// 1   ->     3    ->     4
