class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        graph = build_graph(manager)
        
        queue = collections.deque()
        queue.append((0, headID))
        ans = 0
        while queue:
            curr_time, curr_id = queue.popleft()
            ans = max(ans, curr_time)
            
            next_time = curr_time + informTime[curr_id]
            
            for next_id in graph.get(curr_id, []):
                queue.append((next_time, next_id))
                
        return ans
        
        
def build_graph(managers):
    graph = collections.defaultdict(list)
    for employee, manager in enumerate(managers):
        graph[manager].append(employee)
    return graph
        
        
