# """
# This is GridMaster's API interface.
# You should not implement it, or speculate about its implementation
# """
#class GridMaster(object):
#    def canMove(self, direction: str) -> bool:
#        
#
#    def move(self, direction: str) -> int:
#        
#
#    def isTarget(self) -> None:
#        
#
from queue import PriorityQueue

WALL = -1

DIRECTIONS = {
    'U': (0, 1),
    'D': (0, -1),
    'L': (-1, 0),
    'R': (1, 0),
}

REVERSRED_DIRECTIONS = {
    'U': 'D',
    'D': 'U',
    'L': 'R',
    'R': 'L',
}

class Solution(object):
    def findShortestPath(self, master: 'GridMaster') -> int:
        if master.isTarget():
            return 0
        destination, grid = explore_grid(master)

        # print(grid, destination)
        return find_short_distance(grid, destination) if destination else -1
        
    
def explore_grid(master):
    grid = {}

    
    def dfs(x, y):
        if master.isTarget():
            return (x, y)
        destination = None
        for direction, diff in DIRECTIONS.items():
            diff_x, diff_y = diff
            next_x, next_y = x + diff_x, y + diff_y
            next_point = (next_x, next_y)
            if next_point not in grid:
                if not master.canMove(direction):
                    grid[next_point] = WALL
                else:
                    cost = master.move(direction)
                    grid[next_point] = cost
                    
                    end = dfs(next_x, next_y)
                    if end:
                        destination = end
                    
                    master.move(REVERSRED_DIRECTIONS[direction])
        return destination    
    
    destination = dfs(0, 0)

    return destination, grid

def find_short_distance(grid, destination):
    q = PriorityQueue()
    q.put((0, (0, 0)))
    visited = set()
    visited.add((0, 0))
    while q:
        curr_cost, curr_point = q.get()
        curr_x, curr_y = curr_point
        if curr_point == destination:
            return curr_cost
        for diff_x, diff_y in DIRECTIONS.values():
            next_x, next_y = curr_x + diff_x, curr_y + diff_y
            next_point = (next_x, next_y)
            if next_point in grid and grid[next_point] != WALL and next_point not in visited:
                q.put((curr_cost + grid[next_point], next_point))
                visited.add(next_point)
    return -1
