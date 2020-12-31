# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        paths = find_all_paths(root)
        ans = 0
        for path in paths:
            # print(path)
            ans += to_base_10(path)
        return ans
    
def find_all_paths(root):
    paths = []
    dfs(root, str(root.val), paths)
    return paths
    
def dfs(root, curr_path, paths):
    if root.left is None and root.right is None:
        paths.append(curr_path)
    
    if root.left is not None:
        dfs(root.left, curr_path + str(root.left.val), paths)
    if root.right is not None:
        dfs(root.right, curr_path + str(root.right.val), paths)

def to_base_10(base2_str):
    return int(base2_str, 2)