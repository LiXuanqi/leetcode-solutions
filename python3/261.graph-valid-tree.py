class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        edge_set = set()
        uf = UnionFind(n)
        for start, end in edges:
            edge_set.add((start, end))
            if uf.is_connected(start, end):
                return False
            else:
                uf.union(start, end)
        return len(edge_set) == n - 1
            
        
        
class UnionFind:
    def __init__(self, n):
        self.parents = {}
        for i in range(n):
            self.parents[i] = i
            
    def union(self, a, b):
        parent_a = self.find(a)
        parent_b = self.find(b)
        self.parents[parent_a] = parent_b
        
    def find(self, node):
        curr = node
        while self.parents[curr] != curr:
            curr = self.parents[curr]
            
        return curr
    
    def is_connected(self, a, b):
        return self.find(a) == self.find(b)
        
