# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkEqualTree(self, root: TreeNode) -> bool:
        sums = []
        total_sum = get_tree_sum(root, sums)
        # remove the whole tree
        sums.pop()
        return (total_sum / 2) in sums
        
        
def get_tree_sum(root, sums):
    if root is None:
        return 0
    left_sum = get_tree_sum(root.left, sums)
    right_sum = get_tree_sum(root.right, sums)
    curr_sum = left_sum + root.val + right_sum
    sums.append(curr_sum)
    return curr_sum
    