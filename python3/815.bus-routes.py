class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        
        if source == target:
            return 0
        
        stop_to_route_indexes = get_stop_to_route_index(routes)
        
        queue = collections.deque()
        visited = set()
        
        for route_index in stop_to_route_indexes.get(source, []):
            queue.append(route_index)
            visited.add(route_index)
        
        ans = 1
        while queue:
            for _ in range(len(queue)):
                curr_route_index = queue.popleft()
                if curr_route_index in stop_to_route_indexes[target]:
                    return ans
                for stop in routes[curr_route_index]:
                    for next_route_index in stop_to_route_indexes.get(stop, []):
                        if next_route_index not in visited:
                            queue.append(next_route_index)
                            visited.add(next_route_index)
                    
                
            ans += 1
            
        return -1
    
def get_stop_to_route_index(routes):
    stop_to_route_index = collections.defaultdict(set)
    for route_index, route in enumerate(routes):
        for stop in route:
            stop_to_route_index[stop].add(route_index)
            
    return stop_to_route_index
        
                
