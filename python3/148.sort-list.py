# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def printList(self, head):
        ans = ""
        while head != None:
            ans += str(head.val) + "->"
            head = head.next
        print(ans)
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        slow = head
        fast = head.next
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        newHead = slow.next
        slow.next = None
        head1 = self.sortList(head)
        head2 = self.sortList(newHead)
        dummy = ListNode(-1)
        curr = dummy
        pointerA = head1
        pointerB = head2
        while pointerA is not None and pointerB is not None:
            if pointerA.val < pointerB.val:
                curr.next = pointerA
                pointerA = pointerA.next
            else:
                curr.next = pointerB
                pointerB = pointerB.next
            curr = curr.next
        while pointerA is not None:
            curr.next = pointerA
            pointerA = pointerA.next
            curr = curr.next
        while pointerB is not None:
            curr.next = pointerB
            pointerB = pointerB.next
            curr = curr.next
        curr.next = None
        return dummy.next

        
        