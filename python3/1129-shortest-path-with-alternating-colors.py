class Solution:
    def shortestAlternatingPaths(self, n: int, red_edges: List[List[int]], blue_edges: List[List[int]]) -> List[int]:
        redMap = {}
        blueMap = {}
        
        def buildMap(edges, s_map):
            for start, end in edges:
                s_map.setdefault(start, []).append(end)
            
        buildMap(red_edges, redMap)
        buildMap(blue_edges, blueMap)
        ans = [-1] * n
        # start from red
        def bfs(currColor):
            queue = collections.deque()
            queue.append(0)
            step = 0
            while queue:
                size = len(queue)
                for i in range(size):
                    curr = queue.popleft()
                    ans[curr] = step if ans[curr] == -1 else min(ans[curr], step)
                    currMap = redMap if currColor == 1 else blueMap
                    neighbors = currMap.get(curr, []).copy()
                    toDelete = []
                    for nextNode in neighbors:
                        queue.append(nextNode)
                        toDelete.append(nextNode)
       
                    for delete in toDelete:
                        currMap[curr].remove(delete)
                currColor *= -1
                step += 1
        redMapCopy = copy.deepcopy(redMap)
        blueMapCopy = copy.deepcopy(blueMap)
        bfs(1)
        
        redMap = redMapCopy
        blueMap = blueMapCopy

        bfs(-1)
        
        return ans
                
                         
                
            
            
        