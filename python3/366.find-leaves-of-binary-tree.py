# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: TreeNode) -> List[List[int]]:
        height_to_nodes = collections.defaultdict(list)
        
        def get_height(curr):
            if curr is None:
                return 0
            left = get_height(curr.left)
            right = get_height(curr.right)
            
           
            height = max(left, right) + 1
            height_to_nodes[height].append(curr.val)
            
            return height
        
        get_height(root)
        ans = []
        for k in sorted(height_to_nodes.keys()):
            ans.append(height_to_nodes[k])
            
        return ans
                
                
        
