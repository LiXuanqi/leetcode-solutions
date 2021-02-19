# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, K: int) -> List[int]:
        graph = tree_to_graph(root)
        return level_order_tranversal(graph, start=target.val, level=K)
  
def level_order_tranversal(graph, start, level):
    queue = collections.deque()
    visited = set()
    queue.append(start)
    visited.add(start)
    
    while queue:
        size = len(queue)
        ans = []
        for _ in range(size):
            curr = queue.popleft()
            ans.append(curr)
            for node in graph.get(curr, []):
                if node not in visited:
                    queue.append(node)
                    visited.add(node)
        level -= 1
        if level == -1:
            return ans
    return []
            

def tree_to_graph(root):
    graph = collections.defaultdict(set)
    
    def visit(node):
        if node.left is not None:
            graph[node.val].add(node.left.val)
            graph[node.left.val].add(node.val)
            visit(node.left)
        if node.right is not None:
            graph[node.val].add(node.right.val)
            graph[node.right.val].add(node.val)
            visit(node.right)
    
    visit(root)
    return graph