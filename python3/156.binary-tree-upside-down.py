# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def upsideDownBinaryTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None
        # it is guaranteed that every node in the given tree has either 0 or 2 children.
        if root.left is None and root.right is None:
            return root
        left = self.upsideDownBinaryTree(root.left)
        right = self.upsideDownBinaryTree(root.right)
        root.left.left = right
        root.left.right = root
        root.left = None
        root.right = None
        return left