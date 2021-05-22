class Solution:
    def mostSimilar(self, n: int, roads: List[List[int]], names: List[str], targetPath: List[str]) -> List[int]:
        graph = build_graph(roads)
        name_to_ids = get_name_to_ids(names)
        
        heap = []
        visited = set()
        
        for i in range(n):
 
            start = (1 if i not in name_to_ids.get(targetPath[0], set()) else 0, 0, i)
            heapq.heappush(heap, (start, str(i)))
            visited.add(start)
                
        while heapq:
            curr_state, curr_path = heapq.heappop(heap)
            # print(curr_state, curr_path)
            curr_distance, curr_index, curr_node = curr_state 
            if curr_index == len(targetPath) - 1:

                return curr_path.split(',')
            
            for next_node in graph.get(curr_node, []):
                
                next_distance = curr_distance + (1 if next_node not in name_to_ids.get(targetPath[curr_index + 1], set()) else 0)
                next_state = (next_distance, curr_index + 1, next_node)
                
                if next_state not in visited:
                    heapq.heappush(heap, (next_state, f'{curr_path},{str(next_node)}'))
                    visited.add(next_state)
                    
        return ''
            
def build_graph(roads):
    graph = collections.defaultdict(list)
    for start, end in roads:
        graph[start].append(end)
        graph[end].append(start)
    return graph


def get_name_to_ids(names):
    name_to_ids = collections.defaultdict(set)
    for i, name in enumerate(names):
        name_to_ids[name].add(i)
        
    return name_to_ids
                
        
        
