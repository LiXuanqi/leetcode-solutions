"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        visited = set()
        
        def go_parent(curr):
            if curr is None:
                return
            
            if curr.val in visited:
                return curr
            
            visited.add(curr.val)
            return go_parent(curr.parent)
            
        go_parent(p)
        return go_parent(q)
        
