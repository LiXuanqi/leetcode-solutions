class Solution:
    def frogPosition(self, n: int, edges: List[List[int]], t: int, target: int) -> float:
        tree = build_tree(edges)
        
        queue = collections.deque()
        visited = set()
        
        queue.append((1, 1))
        visited.add(1)

        
        level = 0
        
        while queue:
            for _ in range(len(queue)):
                if level > t:
                    return 0
                    
                curr, curr_chance = queue.popleft()
            
                if curr == target and (is_leave(curr, tree) or t == level):
                    return curr_chance
                
                if curr in tree:
                    next_points = tree[curr]
                    m = len(next_points) - int(curr != 1)

                    for next_point in next_points:
                        if next_point not in visited:
                            queue.append((next_point, curr_chance * (1 / m)))
                            visited.add(next_point)
            
            level += 1
            
        return 0
                    
def build_tree(edges):
    graph = collections.defaultdict(list)
    for a, b in edges:
        graph[a].append(b)
        graph[b].append(a)
    return graph

def is_leave(curr, tree):
    return len(tree.get(curr, [])) - int(curr != 1) == 0

    
    
