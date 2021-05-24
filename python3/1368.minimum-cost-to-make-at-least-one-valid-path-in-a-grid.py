DIRECTIONS = (
    (None, None),
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)
class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        start = (0, 0)
        end = (n - 1, m - 1)
        
        visited = set()
        heap = [(0, start)]
        costs = {
            start: 0
        }
        
        while heap:
            curr_cost, curr = heapq.heappop(heap)
            # print(curr_cost, curr)
            if curr == end:
                return curr_cost
            curr_x, curr_y = curr
            for direction_index, diff in enumerate(DIRECTIONS):
                if direction_index == 0:
                    continue
                diff_x, diff_y = diff
                next_x = diff_x + curr_x
                next_y = diff_y + curr_y
                
                next_point = (next_x, next_y)
                next_cost = curr_cost + int(direction_index != grid[curr_x][curr_y])
                
                if not in_bound(next_x, next_y, n, m) or (
                    next_point in costs and
                    costs[next_point] <= next_cost
                ):
                    continue
                    
                heapq.heappush(heap, (next_cost, next_point))
                costs[next_point] = next_cost
                
                    
        return -1
                   
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
        
        
