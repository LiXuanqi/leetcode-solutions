# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isUnivalTree(self, root: TreeNode) -> bool:
        return self.isSame(root, root.val)
    def isSame(self, root, value):
        if not root:
            return True
        if root.val != value:
            return False
        return self.isSame(root.left, value) and self.isSame(root.right, value)