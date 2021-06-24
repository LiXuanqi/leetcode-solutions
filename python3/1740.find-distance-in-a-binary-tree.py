# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDistance(self, root: TreeNode, p: int, q: int) -> int:
        if p == q:
            return 0
        return helper(root, p, q)[1]
        
def helper(root, p, q):
  
    if root is None:
        return False, None
    left_found_both, left = helper(root.left, p, q)
    right_found_both, right = helper(root.right, p, q)

    if left_found_both:
        return True, left

    if right_found_both:
        return True, right

    if root.val == p or root.val == q:

        if left is not None:
            return True, left
        if right is not None:
            return True, right
        return False, 1
    else:
        if left is not None and right is not None:
            return True, left + right
        if left is not None:
            return False, left + 1
        if right is not None:
            return False, right + 1
        return False, None
            
        
