class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        uf = UnionFind(edges)
        for start, end in edges:
            if uf.is_connected(start, end):
                return [start, end]
            else:
                uf.union(start, end)
        
class UnionFind:
    def __init__(self, edges):
        self.parents = {}
        for start, end in edges:
            self.parents[start] = start
            self.parents[end] = end
    
    def union(self, a, b):
        a_parent = self.find(a)
        b_parent = self.find(b)
        self.parents[a_parent] = b_parent
        
    def find(self, node):
        parent = self.parents[node]
        if parent == node:
            return parent
        return self.find(parent)
    
    def is_connected(self, a, b):
        return self.find(a) == self.find(b)
            
        