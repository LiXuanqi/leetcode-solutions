# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    ans = 0
    def distributeCoins(self, root: 'TreeNode') -> 'int':
        if not root:
            return 0
        self.balance(root)
        return self.ans
    def balance(self, root: 'TreeNode') -> 'int':
        if not root:
            return 0
        left = self.balance(root.left)
        right = self.balance(root.right)
        self.ans += abs(left) + abs(right)
        return root.val - 1 + left + right
        