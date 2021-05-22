class Solution:
    def mostSimilar(self, n: int, roads: List[List[int]], names: List[str], targetPath: List[str]) -> List[int]:
        graph = build_graph(roads)
        name_to_ids = get_name_to_ids(names)
        
        heap = []
        
        min_distances = {}
        pre_node = {}
        for i in range(n):
            distance = 1 if i not in name_to_ids.get(targetPath[0], set()) else 0
            start = (
                distance, 
                0, 
                i
            )
            heapq.heappush(heap, start)
            min_distances[(0, i)] = distance
            pre_node[(0, i)] = -1
                
        while heapq:
            curr_state = heapq.heappop(heap)
            # print(curr_state, curr_path)
            curr_distance, curr_index, curr_node = curr_state 
            if curr_index == len(targetPath) - 1:
             
                return get_path(pre_node, (curr_index, curr_node))
            
            for next_node in graph.get(curr_node, []):
                
                next_distance = curr_distance + (1 if next_node not in name_to_ids.get(targetPath[curr_index + 1], set()) else 0)
                next_pos = (curr_index + 1, next_node)
                next_state = (next_distance, *next_pos)
                
                if next_pos in min_distances and min_distances[next_pos] <= next_distance:
                    continue
                    
                heapq.heappush(heap, next_state)
                min_distances[next_pos] = next_distance
                pre_node[next_pos] = (curr_index, curr_node)
                    
        return ''

def get_path(pre_node, curr_pos):
    if curr_pos == -1:
        return []
    return get_path(pre_node, pre_node[curr_pos]) + [curr_pos[1]]
    
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
                
        
        
