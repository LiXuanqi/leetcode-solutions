class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: List[List[int]], queries: List[List[int]]) -> List[bool]:
        edgeList.sort(key=lambda edge: edge[2])
        
        for index, query in enumerate(queries):
            query.append(index)
            
        queries.sort(key=lambda query: query[2])
  
        # print(edgeList)
        # print(queries)
        
        edge_index = 0
        uf = UnionFind(n)
        
        ans = [False] * len(queries)
        
        for p1, p2, limit, original_index in queries:
            while edge_index < len(edgeList) and edgeList[edge_index][2] < limit:
                start, end, _ = edgeList[edge_index]
                uf.union(start, end)
                edge_index += 1
            ans[original_index] = (uf.is_connected(p1, p2))
        return ans
    
class UnionFind:
    def __init__(self, n):
        self.parents = {
            i: i
            for i in range(n)
        }
        
    def union(self, a, b):
        parent_a = self.find(a)
        parent_b = self.find(b)
        self.parents[parent_a] = parent_b
        
    def find(self, root):
        curr = root
        while curr != self.parents[curr]:
            curr = self.parents[curr]
        ans = curr
        curr = root
        while curr != self.parents[curr]:
            next = self.parents[curr]
            self.parents[curr] = ans
            curr = next
        return ans
    
    def is_connected(self, a, b):
        return self.find(a) == self.find(b)
        
        
        
                
            
        
