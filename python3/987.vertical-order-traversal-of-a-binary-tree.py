# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        coordinates = collections.defaultdict(list)
        visit_and_assign_coordinate(root, 0, 0, coordinates)
        return sort_by_rule(coordinates)
        
    
    
def visit_and_assign_coordinate(root, x, y, coordinates):
    if root is None:
        return
    coordinates[x].append((y, root.val))
    visit_and_assign_coordinate(root.left, x - 1, y + 1, coordinates)
    visit_and_assign_coordinate(root.right, x + 1, y + 1, coordinates)  
 
def sort_by_rule(coordinates):
    ans = []
    # sort by x
    for x in sorted(coordinates.keys()):
        points = coordinates[x]
        # sort by y, if =, sort by value
        points = sorted(points)
        ans.append([val for _, val in points])
    return ans