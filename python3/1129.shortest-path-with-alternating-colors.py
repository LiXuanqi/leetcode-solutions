class Solution:
    def shortestAlternatingPaths(self, n: int, red_edges: List[List[int]], blue_edges: List[List[int]]) -> List[int]:
        graph = [[[], []] for i in range(n)]
        for start, end in red_edges:
            graph[start][0].append(end)
        for start, end in blue_edges:
            graph[start][1].append(end)
        ans = [[2 * n, 2 * n] for i in range(n)]
        ans[0] = [0, 0]
        queue = collections.deque()
        queue.append((0, 1))
        queue.append((0, 0))
        while queue:
            curr_node, curr_color = queue.popleft()
            next_color = curr_color ^ 1
            for next_node in graph[curr_node][curr_color]:
                if ans[next_node][next_color] == 2 * n:
                    ans[next_node][next_color] = ans[curr_node][curr_color] + 1
                    queue.append((next_node, next_color))
        res = []
        for row in ans:
            row_min = min(row)
            res.append(-1 if row_min == 2 * n else row_min)
            
        return res
                
            
                
                         
                
            
            
        