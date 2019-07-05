# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        def findNode(root, target, parent, depth):
            if root is None:
                return -1, None
            if root.val == target or root.val == target:
                return depth, parent
            leftDepth, leftParent = findNode(root.left, target, root, depth + 1)
            rightDepth, rightParent = findNode(root.right, target, root, depth + 1)
            if leftDepth != -1:
                return leftDepth, leftParent
            if rightDepth != -1:
                return rightDepth, rightParent
            return -1, None
        
        xDepth, xParent = findNode(root, x, None, 0)
        yDepth, yParent = findNode(root, y, None, 0)
        return xDepth == yDepth and xParent != yParent
        