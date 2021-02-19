# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findClosestLeaf(self, root: TreeNode, k: int) -> int:
        graph, leaves = build_graph(root)
        queue = collections.deque()
        visited = set()
        queue.append(k)
        visited.add(k)
        while queue:
            curr = queue.popleft()
            if curr in leaves:
                return curr
            for neighbor in graph.get(curr, []):
                if neighbor in visited:
                    continue
                else:
                    queue.append(neighbor)
                    visited.add(neighbor)
        return None
def build_graph(root):
    graph = collections.defaultdict(list)
    queue = collections.deque()
    queue.append(root)
    leaves = set()
    while queue:
        curr = queue.popleft()
        if curr.left is None and curr.right is None:
            leaves.add(curr.val)
        if curr.left is not None:
            queue.append(curr.left)
            graph[curr.val].append(curr.left.val)
            graph[curr.left.val].append(curr.val)
        if curr.right is not None:
            queue.append(curr.right)
            graph[curr.val].append(curr.right.val)
            graph[curr.right.val].append(curr.val)
    return graph, leaves
        