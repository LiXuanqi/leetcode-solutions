# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rob(self, root: TreeNode) -> int:
        return max(helper(root))

def helper(root):
    if root is None:
        return 0, 0
    leftSteal, leftNotSteal = helper(root.left)
    rightSteal, rightNotSteal = helper(root.right)
    steal = root.val + leftNotSteal + rightNotSteal
    notSteal = max(leftSteal, leftNotSteal) + max(rightSteal, rightNotSteal) 
    return steal, notSteal

  