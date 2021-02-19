# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        max_height = find_max_height(root)
        # print(max_height)
        return find_common_ancestor_of_node_with_height(root, max_height, 1)
        
def find_max_height(root):
    if root is None:
        return 0
    return max(find_max_height(root.left), find_max_height(root.right)) + 1

def find_common_ancestor_of_node_with_height(root, target_height, curr_height):
    if root is None:
        return None
    if curr_height == target_height:
        return root
    left = find_common_ancestor_of_node_with_height(root.left, target_height, curr_height + 1)
    right = find_common_ancestor_of_node_with_height(root.right, target_height, curr_height + 1)
    if left is not None and right is not None:
        return root
    if left is not None:
        return left
    if right is not None:
        return right
    return None