# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def boundaryOfBinaryTree(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        return [root.val] + self.get_left_boundary(root.left) + self.get_leaves(root.left) + self.get_leaves(root.right) + list(reversed(self.get_right_boundary(root.right)))
        
    def get_left_boundary(self, root):
        ans = []
        while root is not None:
            ans.append(root.val)
            if root.left is not None:
                root = root.left
            elif root.right is not None:
                root = root.right
            else:
                root = None
        return ans[:-1]
    
    def get_right_boundary(self, root):
        ans = []
        while root is not None:
            ans.append(root.val)
            if root.right is not None:
                root = root.right
            elif root.left is not None:
                root = root.left
            else:
                root = None
        return ans[:-1]
    
    def get_leaves(self, root):
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [root.val]
        return self.get_leaves(root.left) + self.get_leaves(root.right)