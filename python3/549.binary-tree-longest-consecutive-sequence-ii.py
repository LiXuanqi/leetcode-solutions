# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def longestConsecutive(self, root: TreeNode) -> int:
        self.currMax = 0
        self.helper(root)
        return self.currMax
        
    def helper(self, root):
        if root is None:
            return 0, 0
        cin, cde = 1, 1
        lin, lde = self.helper(root.left)
        rin, rde = self.helper(root.right)
        if root.left is not None:
            if root.left.val + 1 == root.val:
                cde = max(cde, lde + 1)
            if root.left.val - 1 == root.val:
                cin = max(cin, lin + 1)
        if root.right is not None:
            if root.right.val + 1 == root.val:
                cde = max(cde, rde + 1)
            if root.right.val - 1 == root.val:
                cin = max(cin, rin + 1)
        self.currMax = max(self.currMax, cin + cde - 1)
        return cin, cde
                
        