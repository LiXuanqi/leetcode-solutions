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
        
        costs = {
            start: 0
        }

        deque = collections.deque()

        deque.append((0, start))
      

        while deque:
            curr_cost, curr = deque.popleft()
        
            curr_x, curr_y = curr
          
            if curr == end:
                return curr_cost
            for direction_index, diff in enumerate(DIRECTIONS):
                if direction_index == 0:
                    continue
                diff_x, diff_y = diff
                next_x = curr_x + diff_x
                next_y = curr_y + diff_y
                next_point = (next_x, next_y)
                next_cost = curr_cost + int(grid[curr_x][curr_y] != direction_index)
                
                if not in_bound(next_x, next_y, n, m) or (
                    next_point in costs and
                    costs[next_point] <= next_cost
                ):
                    continue
                    
                if grid[curr_x][curr_y] == direction_index:
                    deque.appendleft((next_cost, next_point))
                else:
                    deque.append((next_cost, next_point)) 
                    
                costs[next_point] = next_cost

        return -1

def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
    
        
