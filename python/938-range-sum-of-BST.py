# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        self.ans = 0
        def dfs(root, L, R):
            if root:
                if L <= root.val <= R:
                    self.ans += root.val
                if L <= root.val:
                    dfs(root.left, L, R)
                if root.val <= R:
                    dfs(root.right, L, R)
        dfs(root, L, R)
        return self.ans
