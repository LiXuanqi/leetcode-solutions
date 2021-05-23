# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        to_delete = set(to_delete)
        
        ans = []
        
        def delete(curr, is_root):
            if curr is None:
                return None
            root_deleted = False
            if curr.val in to_delete:
                root_deleted = True

            if not root_deleted and is_root:
                ans.append(curr)

            curr.left = delete(curr.left, root_deleted)
            curr.right = delete(curr.right, root_deleted)
            
            return curr if not root_deleted else None
        
        delete(root, True)
        return ans
