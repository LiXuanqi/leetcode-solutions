# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:
        return getLeaves(root1) == getLeaves(root2)
def getLeaves(root):
    if not root:
        return []
    if not root.left and not root.right:
        return [root.val]
    ans = []
    ans.extend(getLeaves(root.left))
    ans.extend(getLeaves(root.right))
    return ans