class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        distances = sorted([
            (calculate_distance(points[i], points[j]), i, j)
            for i in range(len(points) - 1)
            for j in range(i + 1, len(points))
        ])
        
        union_find = UnionFind(len(points))
        
        cost = 0
        n = len(points) - 1
        
        for distance, i, j in distances:
            if not union_find.is_connected(i, j):
                cost += distance
                union_find.union(i, j)
                n -= 1
                if n == 0:
                    return cost
                
        return 0
        
def calculate_distance(point_1, point_2):
    return abs(point_1[0] - point_2[0])+ abs(point_1[1] - point_2[1])

class UnionFind:
    def __init__(self, n):
        self.parents = {}
        for i in range(n):
            self.parents[i] = i
    
    def union(self, i, j):
        parent_i = self.find(i)
        parent_j = self.find(j)
        self.parents[parent_i] = parent_j
        
    def find(self, node):
        curr = node
        while self.parents[curr] != curr:
            curr = self.parents[curr]
        return curr
    
    def is_connected(self, i, j):
        return self.find(i) == self.find(j)
