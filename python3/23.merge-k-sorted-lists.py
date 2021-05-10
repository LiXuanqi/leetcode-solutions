# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        min_heap = []
        for index, node in enumerate(lists):
            if node is not None:
                heapq.heappush(min_heap, (node.val, index, node));
        
        dummy = ListNode()
        curr = dummy
        while min_heap:
            _, index, min_node = heapq.heappop(min_heap)
            curr.next = min_node
            curr = curr.next
            
            if min_node.next is not None:
                next_node = min_node.next
                min_node.next = None
                
                heapq.heappush(min_heap, (next_node.val, index, next_node))
                
        return dummy.next
