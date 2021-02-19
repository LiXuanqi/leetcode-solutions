# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        self.ans = []
        self.get_subtree(root, collections.defaultdict(int))
        return self.ans
        
    def get_subtree(self, root, visited):
        if root is None:
            return "null"
        if root.left is None and root.right is None:
            val = str(root.val)
            if visited[val] == 1:
                self.ans.append(root)
            visited[val] += 1
            return val
        
        encode_tree = str(root.val)
        encode_tree += "(" + self.get_subtree(root.left, visited) + ")"
        encode_tree += "(" + self.get_subtree(root.right, visited) + ")"
        if visited[encode_tree] == 1:
            self.ans.append(root)
        visited[encode_tree] += 1
        return encode_tree
        