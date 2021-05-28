ROOT = 0

class TreeAncestor:

    def __init__(self, n: int, parent: List[int]):
        graph = build_graph(parent)
        
        self.ancestors = collections.defaultdict(list)
        
        def dfs(curr, path):
            i = 1
            # print(curr, path)
            while len(path) - 1 - i >= 0:
                self.ancestors[curr].append(path[len(path) - 1 - i])
                i *= 2
                
            for next_node in graph.get(curr, []):
                path.append(next_node)
                dfs(next_node, path)
                path.pop()
        
        dfs(ROOT, [0])
        
        # print(self.ancestors)
        
            
        

    def getKthAncestor(self, node: int, k: int) -> int:
        if k == 0:
            return node
        if node == ROOT:
            return -1
        leftmost_bit = min(k.bit_length() - 1, len(self.ancestors[node]) - 1)
        # print(node, k, leftmost_bit)
        # print(self.ancestors[node])
        prev = self.ancestors[node][leftmost_bit]
        return self.getKthAncestor(prev, k - (1 << leftmost_bit))
    
def build_graph(parent):
    graph = collections.defaultdict(list)
    for node, prev in enumerate(parent):
        graph[prev].append(node)
    return graph
        
        


# Your TreeAncestor object will be instantiated and called as such:
# obj = TreeAncestor(n, parent)
# param_1 = obj.getKthAncestor(node,k)