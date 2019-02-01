# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    ans = float('inf')
    prev = float('-inf')
    def getMinimumDifference(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.helper(root)
        return self.ans
    def helper(self, root):
        if not root:
            return
        self.helper(root.left)
        diff = abs(root.val - self.prev)
        self.prev = root.val
        self.ans = min(self.ans, diff);
        self.helper(root.right)
        
        