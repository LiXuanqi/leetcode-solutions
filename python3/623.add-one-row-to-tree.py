# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: TreeNode, v: int, d: int) -> TreeNode:
        
        if root is None:
            return None
        
        if d == 1:
            return TreeNode(v, left=root)
        
        if d == 2:
            root.left = TreeNode(v, left=root.left)
            root.right = TreeNode(v, right=root.right)
            return root
        
        root.left = self.addOneRow(root.left, v, d - 1)
        root.right = self.addOneRow(root.right, v, d - 1)
        
        return root