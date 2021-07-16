# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestKValues(self, root: TreeNode, target: float, k: int) -> List[int]:
        
        ans = []
        pre_stack = []
        suc_stack = []
        
        curr = root
        
        while curr is not None:
            if curr.val < target:
                pre_stack.append(curr)
                curr = curr.right
            else:
                suc_stack.append(curr)
                curr = curr.left
                
        def get_prev():
            if pre_stack:
                prev_node = pre_stack.pop()
                curr = prev_node.left
                while curr is not None:
                    pre_stack.append(curr)
                    curr = curr.right
                    
                return prev_node
            
        def get_next():
            if suc_stack:
                next_node = suc_stack.pop()
                curr = next_node.right
                while curr is not None:
                    suc_stack.append(curr)
                    curr = curr.left
                    
                return next_node
            
        prev = get_prev()
        next = get_next()
        
        while k:
            if prev and next is None:
                ans.append(prev.val)
                prev = get_prev()
            elif prev is None and next:
                ans.append(next.val)
                next = get_next()
            else:
                if abs(prev.val - target) <= abs(next.val - target):
                    ans.append(prev.val)
                    prev = get_prev()
                else:
                    ans.append(next.val)
                    next = get_next()   
                    
            k -= 1
            
        return ans
            
            
            
