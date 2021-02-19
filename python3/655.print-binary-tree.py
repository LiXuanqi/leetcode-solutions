# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def printTree(self, root: TreeNode) -> List[List[str]]:
        canvas = get_canvas(get_height(root))
        draw(
            canvas,
            root,
            left=0, 
            right=len(canvas[0])-1, 
            height=0
        )
        return canvas
        
def draw(canvas, root, left, right, height):
    if height >= len(canvas):
        return
    index = (right + left) // 2
    canvas[height][index] = str(root.val)
    if root.left is not None:
        draw(canvas, root.left, left, index - 1, height + 1)
    if root.right is not None:
        draw(canvas, root.right, index + 1, right, height + 1)
        
def get_height(root):
    if root is None:
        return 0
    return max(get_height(root.left), get_height(root.right)) + 1

def get_canvas(height):
    return [[""] * (2 ** height - 1) for _ in range(height)]