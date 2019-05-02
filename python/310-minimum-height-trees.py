class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n < 0:
            return []
        if n == 1:
            return [0]
        graph = {}
        # - build graph
        for start, end in edges:
            graph.setdefault(start, set()).add(end)
            graph.setdefault(end, set()).add(start)
            
        # - find leaves
        leaves = [k for k, v in graph.items() if len(v) == 1]
        while n > 2:
            n -= len(leaves)
            newLeaves = []
            for leave in leaves:
                next = graph[leave].pop()

                graph[next].remove(leave)
                if len(graph[next]) == 1:
                    newLeaves.append(next)
            leaves = newLeaves
        return leaves
            
        