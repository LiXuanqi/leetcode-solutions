# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def countUnivalSubtrees(self, root: TreeNode) -> int:
        
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        return self.countUnivalSubtrees(root.left) + self.countUnivalSubtrees(root.right) + (1 if isUnivalSubtree(root) else 0)
        
def isUnivalSubtree(root):
    if root is None:
        return True
    if root.left is None and root.right is None:
        return True
    if root.left is None:
        return isUnivalSubtree(root.right) and root.right.val == root.val
    if root.right is None:
        return isUnivalSubtree(root.left) and root.left.val == root.val
    return isUnivalSubtree(root.left) and isUnivalSubtree(root.right) and root.left.val == root.right.val == root.val