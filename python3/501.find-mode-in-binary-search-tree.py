# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def findMode(self, root: TreeNode) -> List[int]:
        self.nums = []
        self.tranverse(root)
        return self.find_common(self.nums)
        
    def tranverse(self, root):
        if root is None:
            return
        self.tranverse(root.left)
        self.nums.append(root.val)
        self.tranverse(root.right)
        
    def find_common(self, nums):
        if not nums:
            return []
        ans = []
        max_count = float('-inf')
        curr_num = nums[0]
        curr_count = 0
        
        for num in nums:
            if num == curr_num:
                curr_count += 1
            else:
                curr_num = num
                curr_count = 1

            if curr_count > max_count:
                ans = [curr_num]
                max_count = curr_count
            elif curr_count == max_count:
                curr_count == max_count
                ans.append(curr_num)
                    
                    
        return ans 
                
        