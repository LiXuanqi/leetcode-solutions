class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        uf = UnionFind(n)
        for x in range(n):
            for y in range(n):
                if x != y and isConnected[x][y]:
                    uf.union(x, y)
                    
        return uf.group_num

class UnionFind:
    def __init__(self, n):
        self.parents = {}
        for i in range(n):
            self.parents[i] = i
        self.group_num = n
        
    def union(self, x, y):
        parent_x = self.find(x)
        parent_y = self.find(y)
        
        if parent_x != parent_y:
            self.parents[parent_x] = parent_y
            self.group_num -= 1
    
    def find(self, node):
        curr = node
        while curr != self.parents[curr]:
            curr = self.parents[curr]
        
        parent = curr
        
        curr = node
        while curr != self.parents[curr]:
            prev = curr
            curr = self.parents[curr]
            self.parents[prev] = parent
            
        return parent
