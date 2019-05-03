# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def largestBSTSubtree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        self.ans = 0
        
        def helper(root):
            if root is None:
                return 0, float('inf'), float('-inf')
            leftSize, leftLower, leftUpper = helper(root.left)
            rightSize, rightLower, rightUpper = helper(root.right)
            if any([leftSize == -1, rightSize == -1, leftUpper >= root.val, rightLower <= root.val]):
                return -1, float('-inf'), float('inf')
            size = leftSize + rightSize + 1
            self.ans = max(self.ans, size)
    
            return size, min(leftLower, root.val), max(rightUpper, root.val)
        
        helper(root)
        return self.ans