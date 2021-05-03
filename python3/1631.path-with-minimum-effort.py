import numpy as np
from queue import PriorityQueue

DIRECTIONS = ((0, 1), (0, -1), (1, 0), (-1, 0))
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        distances = np.full((len(heights), len(heights[0])), np.inf)
        distances[0][0] = 0
        pq = PriorityQueue()
        pq.put((0, (0, 0)))
        while not pq.empty():
            curr_cost, curr_pos = pq.get()
            for direction in DIRECTIONS:
                next_x = curr_pos[0] + direction[0]
                next_y = curr_pos[1] + direction[1]
                if in_bound(next_x, next_y, heights):
                    cost = max(abs(heights[next_x][next_y] - heights[curr_pos[0]][curr_pos[1]]), curr_cost)
                    if cost < distances[next_x][next_y]:
                        distances[next_x][next_y] = cost
                        pq.put((cost, (next_x, next_y)))
            # print(distances)
            
        return int(distances[len(heights) - 1][len(heights[0]) - 1])
                    
                    
                    
                    
def in_bound(x, y, matrix):
    return 0 <= x < len(matrix) and 0 <= y < len(matrix[0])