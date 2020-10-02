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
    def inorderSuccessor(self, node: 'Node') -> 'Node':
        # The successor of a node is the node with the smallest key greater than node.val.
        # Two possible:
        # 1. the leftmost leaf node
        # 2. one of parent node
        if node.right is not None:
            return get_leftmost_leaf_node(node.right)
        return find_all_parent_nodes(node)
    
def get_leftmost_leaf_node(node):
    curr = node
    while curr.left is not None:
        curr = curr.left
    return curr

def find_all_parent_nodes(node):
    while node.parent is not None and node.parent.left != node:
        node = node.parent
    return node.parent
