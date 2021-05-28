# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: TreeNode) -> int:
        if root is None:
            return 0
        left_height = get_height(root.left)
        right_height = get_height(root.right)
        
        if left_height == right_height:
            # ans in right
            return 1 + get_full_binary_tree_count(left_height) + self.countNodes(root.right)
        else:
            # ans in left
            return 1 + get_full_binary_tree_count(right_height) + self.countNodes(root.left)
        

def get_height(root):
    if root is None:
        return 0
    return get_height(root.left) + 1

def get_full_binary_tree_count(height):
    return (1 << height) - 1
        
