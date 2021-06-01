DIRECTIONS = (
    (0, 1),
    (1, 0),
    (0, -1),
    (-1, 0)
)
class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        start = encode(board)
        end = encode([[1, 2, 3], [4, 5, 0]])

        queue = collections.deque()
        queue.append(start)
        visited = set()
        visited.add(start)
        
        ans = 0
        
        while queue:
            for _ in range(len(queue)):
                curr_board = queue.popleft()
                # print(curr_board)
                if curr_board == end:
                    return ans
               
                for next_board in get_next_boards(decode(curr_board)):
                    encoded_next_board = encode(next_board)
                    if encoded_next_board not in visited:
                        queue.append(encoded_next_board)
                        visited.add(encoded_next_board)
                
            ans += 1
        return -1
        
def encode(board):
    return tuple(tuple(row) for row in board)
    
def decode(board):
    return list(list(row) for row in board)
    
def get_next_boards(curr_board):
    n, m = len(curr_board), len(curr_board[0])
    for x in range(n):
        for y in range(m):
            if curr_board[x][y] == 0:
                for diff_x, diff_y in DIRECTIONS:
                    next_x = x + diff_x
                    next_y = y + diff_y
                    if in_bound(next_x, next_y, n, m):
                        next_board = copy.deepcopy(curr_board)
                        next_board[x][y] = next_board[next_x][next_y]
                        next_board[next_x][next_y] = 0
                        yield next_board
                        
def in_bound(x, y, n, m):
    return 0 <= x < n and 0 <= y < m
