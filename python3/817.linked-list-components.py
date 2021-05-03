# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def numComponents(self, head: ListNode, G: List[int]) -> int:
        
        curr = head
        
        G = set(G)
        ans = 0
        
        has_group = False
        
        while curr != None:
            val = curr.val
            
            if val not in G:
                if has_group:
                    ans += 1
                    has_group = False
            else:
                has_group = True
            
            curr = curr.next
            
        if has_group:
            ans += 1
            
        return ans
                
        