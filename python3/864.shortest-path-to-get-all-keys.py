DIRECTIONS = (
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0)
)

class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        n, m = len(grid), len(grid[0])
        
        queue = collections.deque()
        visited = set()
        
        end_keys = 0
        
        for x in range(n):
            for y in range(m):
                c = grid[x][y]
                if c == '@':
                    start = ((x, y), 0)
                    queue.append(start)
                    visited.add(start)
                elif is_key(c):
                    end_keys |= (1 << char_to_int(c))
        ans = 0           
        while queue:
            for _ in range(len(queue)):
                curr_point, curr_keys = queue.popleft()
                curr_x, curr_y = curr_point
                if curr_keys == end_keys:
                    return ans
                for diff_x, diff_y in DIRECTIONS:
                    next_x = curr_x + diff_x
                    next_y = curr_y + diff_y
                    if in_bound(next_x, next_y, n, m) and grid[next_x][next_y] != '#':
                        if is_wall(grid[next_x][next_y]) and not can_pass(grid[next_x][next_y], curr_keys):
                            continue
                        
                        if is_key(grid[next_x][next_y]):
                            next_keys = curr_keys | (1 << char_to_int(grid[next_x][next_y]))
                        else:
                            next_keys = curr_keys
                        next_state = ((next_x, next_y), next_keys)
                        if next_state not in visited:
                            queue.append(next_state)
                            visited.add(next_state)
            ans += 1
        return -1
    
def can_pass(lock, curr_keys):
    return (1 << ord(lock) - ord('A')) & curr_keys != 0
    
def is_wall(c):
    return c in 'ABCDEF'
            
def is_key(c):
    return c in 'abcdef'
        
def char_to_int(c):
    return ord(c) - ord('a')

def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
