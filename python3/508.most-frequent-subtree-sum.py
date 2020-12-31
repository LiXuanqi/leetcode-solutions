# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findFrequentTreeSum(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        self.subtree_sums = []
        self.tranverse(root)
        counter = collections.Counter(self.subtree_sums).most_common()
        max_freq = counter[0][1]
        ans = []
        for val, freq in counter:
            if freq == max_freq:
                ans.append(val)
        return ans
        
    def tranverse(self, root):
        if root.left is None and root.right is None:
            self.subtree_sums.append(root.val)
            return root.val
        subtree_sum = root.val
        if root.left is not None:
            subtree_sum += self.tranverse(root.left)
        if root.right is not None:
            subtree_sum += self.tranverse(root.right)
        self.subtree_sums.append(subtree_sum)
        return subtree_sum