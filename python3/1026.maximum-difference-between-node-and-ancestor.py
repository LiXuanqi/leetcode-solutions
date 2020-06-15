i# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: TreeNode) -> int:
        return get_max_diff(root, root.val, root.val)
        
        
def get_max_diff(node, max_parent, min_parent):
    if node is None:
        return float('-inf')
    curr_diff = max(abs(max_parent - node.val), abs(min_parent - node.val))
    max_parent = max(node.val, max_parent)
    min_parent = min(node.val, min_parent)
    
    return max(curr_diff, get_max_diff(node.left, max_parent, min_parent), get_max_diff(node.right, max_parent, min_parent))