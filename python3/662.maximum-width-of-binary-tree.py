# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        queue = collections.deque()
        queue.append((root, 0))
        ans = 0
        while queue:
            size = len(queue)
            min_index = float('inf')
            max_index = float('-inf')
            for _ in range(size):
                curr_node, curr_index = queue.popleft()
                min_index = min(min_index, curr_index)
                max_index = max(max_index, curr_index)
                if curr_node.left is not None:
                    queue.append((curr_node.left, curr_index * 2))
                if curr_node.right is not None:
                    queue.append((curr_node.right, curr_index * 2 + 1))
            ans = max(ans, max_index - min_index + 1)
        return ans
        