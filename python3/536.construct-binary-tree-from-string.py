# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def str2tree(self, s: str) -> TreeNode:
        if s == '':
            return None
        left_index = s.find('(')
        if left_index < 0:
            return TreeNode(int(s))
        
        unmatched_parenthesis = 0
        right_index = -1
        for index, c in enumerate(s):
            if c == '(':
                unmatched_parenthesis += 1
            elif c == ')':
                unmatched_parenthesis -= 1
            if index > left_index and unmatched_parenthesis == 0:
                right_index = index
                break
        root = TreeNode(int(s[:left_index]))
        left = self.str2tree(s[left_index + 1: right_index])
        right = self.str2tree(s[right_index + 2: -1])
        root.left = left
        root.right = right
        return root