# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCompleteTree(self, root: TreeNode) -> bool:
        nodes = [(root, 1)]
        i = 0
        while i < len(nodes):
            node, index = nodes[i]
            i += 1
            if node:
                nodes.append((node.left, 2 * index))
                nodes.append((node.right, 2 * index + 1))
        return nodes[-1][1] == len(nodes)
