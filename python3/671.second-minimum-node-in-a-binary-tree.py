# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        self.ans = float('inf')
        self.tranverse(root, root.val)
        return self.ans if self.ans != float('inf') else -1
    def tranverse(self, root, min_val):
        if root is None:
            return
        if min_val < root.val < self.ans:
            self.ans = root.val
        self.tranverse(root.left, min_val)
        self.tranverse(root.right, min_val)