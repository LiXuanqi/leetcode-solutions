class Solution:
    def sumOfDistancesInTree(self, N: int, edges: List[List[int]]) -> List[int]:
        tree = build_tree(edges)
        # include node itself
        sub_node_counts = [0] * N
        total_distances = [0] * N
        
        def dfs(curr, visited):
            total_node_num = 1
            total_distance = 0
            for child in tree.get(curr, []):
                if child not in visited:
                    visited.add(child)
                    node_num, distance = dfs(child, visited)
                    
                    
                    total_node_num += node_num
                    total_distance += (distance + node_num)
            
            sub_node_counts[curr] = total_node_num
            total_distances[curr] = total_distance
            
            return total_node_num, total_distance
        
        def dfs2(curr, visited):
            for child in tree.get(curr, []):
                if child not in visited:
                    
                    total_distances[child] = total_distances[curr] - sub_node_counts[child] + (N - sub_node_counts[child])
                    visited.add(child)
                    dfs2(child, visited)
        
        dfs(0, {0})
        
        dfs2(0, {0})
        
        
        # print(sub_node_counts)
        # print(total_distances)
        return total_distances
        
        
def build_tree(edges):

    tree = collections.defaultdict(list)
    for a, b in edges:
        tree[a].append(b)
        tree[b].append(a)
    return tree
    
    
    
            
            
