# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        result = []
        helper = root
        stack = []
        while stack or helper is not None:
            while helper is not None:
                stack.append(helper)
                helper = helper.left
            curr = stack.pop()
            result.append(curr.val)
            if curr.right is not None:
                helper = curr.right
        return result