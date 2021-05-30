# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class CBTInserter:

    def __init__(self, root: TreeNode):
        self.root = root
        self.nodes = []
        
        queue = collections.deque()
        queue.append(root)
        while queue:
            curr = queue.popleft()
            self.nodes.append(curr)
            if curr.left is not None:
                queue.append(curr.left)
            if curr.right is not None:
                queue.append(curr.right)
        

    def insert(self, v: int) -> int:
        node = TreeNode(v)
        self.nodes.append(node)
        new_index = len(self.nodes) - 1
        if new_index % 2 != 0:
            # left
            parent_node = self.nodes[(new_index - 1) // 2]
            parent_node.left = node
            return parent_node.val
        else:
            # right
            parent_node = self.nodes[(new_index - 2) // 2]
            parent_node.right = node
            return parent_node.val
        
        
        

    def get_root(self) -> TreeNode:
        return self.root
        


# Your CBTInserter object will be instantiated and called as such:
# obj = CBTInserter(root)
# param_1 = obj.insert(v)
# param_2 = obj.get_root()
