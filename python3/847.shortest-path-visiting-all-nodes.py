class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        queue = collections.deque()
        visited = set()
        
        end_state = int('1' * len(graph), 2)
        
        for i in range(len(graph)):
            
            state = (i, (1 << i))
            
            queue.append(state)
            visited.add(state)
            
        ans = 0
        
        while queue:
            for _ in range(len(queue)):
                curr_node, curr_state = queue.popleft()
                
                if curr_state == end_state:
                    return ans
                
                for next_node in graph[curr_node]:
                    next_state = curr_state | (1 << next_node)
                    next = (next_node, next_state)
                    if next not in visited:
                        queue.append(next)
                        visited.add(next)
                
            ans += 1
        
        return -1
        
