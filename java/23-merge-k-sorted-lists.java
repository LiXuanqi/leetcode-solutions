/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((node1, node2) -> {
            return node1.val < node2.val ? -1 : 1;
        });
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);      
            }
        }
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        curr.next = null;
        return dummy.next;
    }
}