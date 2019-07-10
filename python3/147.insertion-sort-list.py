# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        if not head:
            return None
        dummy = ListNode(float('-inf'))
        curr = head
        prev = dummy
        while curr is not None:
            next = curr.next
            while prev.next != None and prev.next.val < curr.val:
                prev = prev.next
            curr.next = prev.next
            prev.next = curr
            curr = next
            prev = dummy
        return dummy.next
            