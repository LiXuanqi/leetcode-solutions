DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)
class UnionFind:
    def __init__(self, grid):
        self._n = len(grid)
        total = self._n * self._n
        self.parent = list(range(total))
        self.size = [1] * total

    def find(self, id):
        if self.parent[id] != id:
            self.parent[id] = self.find(self.parent[id])
        return self.parent[id]

    def union(self, p_1, p_2):
        parent_1 = self.find(self.to_id(p_1))
        parent_2 = self.find(self.to_id(p_2))
        if parent_1 != parent_2:
            self.parent[parent_1] = parent_2
            self.size[parent_2] += self.size[parent_1]
    
    def to_id(self, point):
        return point[0] * self._n + point[1]

    def get_size(self, point):
        parent = self.find(self.to_id(point))
        return self.size[parent]


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        uf = UnionFind(grid)
        zeros = []
        n = len(grid)
        for x in range(n):
            for y in range(n):
                if grid[x][y] == 0:
                    zeros.append((x, y))
                else:
                    for diff_x, diff_y in DIRECTIONS:
                        next_x = x + diff_x
                        next_y = y + diff_y
                        if is_valid(next_x, next_y, n) and grid[next_x][next_y] == 1:
                            uf.union((x, y), (next_x, next_y))
        ans = max(uf.size)
        for x, y in zeros:
            possible = 1
            neighbor_parents = set()
            for diff_x, diff_y in DIRECTIONS:
                next_x = x + diff_x
                next_y = y + diff_y
                
                if is_valid(next_x, next_y, n) and grid[next_x][next_y] == 1:
                    # try to connect
                    parent_next = uf.find(uf.to_id((next_x, next_y)))
                    if parent_next not in neighbor_parents:
                        possible += uf.get_size((next_x, next_y))
                        neighbor_parents.add(parent_next)
                ans = max(ans, possible)
        return ans


def is_valid(x, y, n):
    return 0 <= x < n and 0 <= y < n
        
