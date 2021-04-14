# """
# This is GridMaster's API interface.
# You should not implement it, or speculate about its implementation
# """
#class GridMaster(object):
#    def canMove(self, direction: str) -> bool:
#        
#
#    def move(self, direction: str) -> bool:
#        
#
#    def isTarget(self) -> None:
#        
#
EMPTY = 0
WALL = 1
TARGET = 2

DIRECTIONS = {
    'U': (0, 1),
    'D': (0, -1),
    'L': (-1, 0),
    'R': (1, 0)
}
REVERSERD_DIRECTIONS = {
    'U': 'D',
    'D': 'U',
    'L': 'R',
    'R': 'L',
}

class Solution(object):
    def findShortestPath(self, master: 'GridMaster') -> int:
        matrix = get_matrix(master)

        return find_minimum_distance(matrix)
        
def get_matrix(master):
    matrix = {
        (0, 0): TARGET if master.isTarget() else EMPTY
    }
    
    def _dfs(x, y):
        if master.isTarget():
            matrix[(x, y)] = TARGET
        else:
            matrix[(x, y)] = EMPTY
        for direction, diff in DIRECTIONS.items():
            diff_x, diff_y = diff
            next_x = diff_x + x
            next_y = diff_y + y
            next_point = (next_x, next_y)
            if next_point not in matrix:
                if master.canMove(direction):
                    master.move(direction)
                    _dfs(next_x, next_y)
                    master.move(REVERSERD_DIRECTIONS[direction])
                else:
                    matrix[next_point] = WALL
    
    _dfs(0, 0)
    return matrix

def find_minimum_distance(matrix):
    queue = collections.deque()
    queue.append((0, 0))
    visited = set()
    ans = 0
    while queue:
        for _ in range(len(queue)):
            curr = queue.popleft()
            x, y = curr
            if matrix[curr] == TARGET:
                return ans
            for _, diff in DIRECTIONS.items():
                diff_x, diff_y = diff
                next_x = diff_x + x
                next_y = diff_y + y
                next_point = (next_x, next_y)
                if matrix[next_point] != WALL and next_point not in visited:
                    queue.append(next_point)
                    visited.add(next_point)
        ans += 1
    return -1  
        

