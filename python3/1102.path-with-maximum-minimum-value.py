DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def maximumMinimumPath(self, A: List[List[int]]) -> int:
        
        n, m = len(A), len(A[0])
        
        # sort by value, DESC order
        points = sorted([(x, y) for x in range(n) for y in range(m)], key=lambda point: -A[point[0]][point[1]])
        
        uf = UnionFind(n, m, A)
        curr_min = float('inf')
        for point in points:
            x, y = point
            curr_min = min(curr_min, A[x][y])
            for diff_x, diff_y in DIRECTIONS:
                next_x, next_y = x + diff_x, y + diff_y
                if in_bound(next_x, next_y, n, m) and A[next_x][next_y] >= curr_min:
                    uf.union((next_x, next_y), (x, y))
                    if uf.is_union((0, 0), (n - 1, m - 1)):
                        return curr_min
        
        return None

def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
        
class UnionFind:
    def __init__(self, n, m, A):
        self.n = n
        self.m = m
        self.parents = list(range(n * m))
        self.A = A
        
    def union(self, point_1, point_2):
        id_1 = self.to_1d(point_1)
        id_2 = self.to_1d(point_2)
        parent_1 = self.find(id_1)
        parent_2 = self.find(id_2)
        self.parents[parent_1] = parent_2
        
    def find(self, index):
        curr_id = index
        while curr_id != self.parents[curr_id]:
            curr_id = self.parents[curr_id]
            
        parent = curr_id
        
        curr_id = index
        
        while curr_id != self.parents[curr_id]:
            next_id = self.parents[curr_id]
            self.parents[curr_id] = parent
            curr_id = next_id
        return curr_id
    
    def is_union(self, point_1, point_2):
        id_1 = self.to_1d(point_1)
        id_2 = self.to_1d(point_2)
        parent_1 = self.find(id_1)
        parent_2 = self.find(id_2)
        return parent_1 == parent_2
    
    def to_1d(self, point):
        return point[0] * self.m + point[1]
        
