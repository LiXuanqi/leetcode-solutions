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
      PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
          @Override
          public int compare(ListNode node1, ListNode node2) {
              return node1.val < node2.val ? -1 : 1;
          }
      });
      
      for (int i = 0; i < lists.length; i++) {
          if (lists[i] != null) {
              pQueue.add(lists[i]);    
          }
      }
      
      ListNode dummy = new ListNode(-1);
      ListNode curr = dummy;
      while (!pQueue.isEmpty()) {
          ListNode node = pQueue.poll();
          curr.next = node;
          curr = curr.next;
          if (node.next != null) {
              pQueue.add(node.next);   
          }    
      }
      return dummy.next;
  }
}