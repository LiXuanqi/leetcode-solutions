# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lcaDeepestLeaves(self, root: TreeNode) -> TreeNode:
        parents = {}
        
        def findDeepestLeaves(root):
            deepestLeaves = []
            queue = collections.deque()
            queue.append(root)
            while queue:
                size = len(queue) 
                deepestLeaves = []
                for i in range(size):
                    curr = queue.popleft()
                    deepestLeaves.append(curr)
                    if curr.left is not None:
                        queue.append(curr.left)
                        parents[curr.left] = curr 
                    if curr.right is not None:
                        queue.append(curr.right)
                        parents[curr.right] = curr
            return deepestLeaves
        
        deepestLeaves = findDeepestLeaves(root)
        while len(deepestLeaves) > 1: 
            new_leaves = set()
            for leaves in deepestLeaves:
                new_leaves.add(parents[leaves])
            deepestLeaves = new_leaves
        
        return list(deepestLeaves)[0]
            
                
        