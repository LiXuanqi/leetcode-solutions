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
        self.ans = 0
        self.isUnivalSubtree(root)
        return self.ans
        
    def isUnivalSubtree(self, root):
        if root.left is None and root.right is None:
            self.ans += 1
            return True
        if root.left is None:
            isUni = self.isUnivalSubtree(root.right) and root.right.val == root.val
            self.ans += isUni
            return isUni
        if root.right is None:
            isUni = self.isUnivalSubtree(root.left) and root.left.val == root.val
            self.ans += isUni
            return isUni
        # - 如果用if,短路会造成遍历不完所有subtrees.
        isUni = all([self.isUnivalSubtree(root.left), self.isUnivalSubtree(root.right), root.left.val == root.right.val == root.val])
        self.ans += isUni
        return isUni