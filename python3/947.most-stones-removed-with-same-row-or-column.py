Point = collections.namedtuple('Point', 'x, y')
class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        if not stones:
            return 0
        visited = [False] * len(stones)
        count = 0
        for index, stone in enumerate(stones):
            if not visited[index]:
                visited[index] = True
                bfs(stones, visited, stone)
                count += 1
        return len(stones) - count
    
def bfs(stones, visited, start):
    queue = collections.deque()
    queue.append(Point(*start))
    while queue:
        curr = queue.popleft()
        for index, stone in enumerate(stones):
            if not visited[index]:
                x, y = stone
                if x == curr.x or y == curr.y:
                    visited[index] = True
                    queue.append(Point(x, y))
                
        
#   x x
# x   x
# x x

# x   x
#   x
# x   x