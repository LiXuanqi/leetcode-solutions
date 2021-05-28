# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    @functools.lru_cache(None)
    def allPossibleFBT(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        if n == 1:
            return [TreeNode()]
        ans = []
       
        for left_num, right_num in all_combinations(n - 1):
            lefts = self.allPossibleFBT(left_num)
            rights = self.allPossibleFBT(right_num)
            for left in lefts:
                for right in rights:
                    ans.append(TreeNode(
                        left=left,
                        right=right
                    ))
        return ans
    
def all_combinations(n):
    ans = []
    for left in range(1, n ,2):
        ans.append((left, n - left))
    return ans
        
