class Solution:
    def minimumSemesters(self, n: int, relations: List[List[int]]) -> int:
        graph = collections.defaultdict(list)
        indegrees = collections.defaultdict(int)
        for start, end in relations:
            graph[start].append(end)
            indegrees[end] += 1
            
        queue = collections.deque()
        visited = set()
        
        for course_id in range(1, n + 1):
            if indegrees[course_id] == 0:
                queue.append(course_id)
                visited.add(course_id)
                
        ans = 0
        
        while queue:
            for _ in range(len(queue)):
                curr_id = queue.popleft()
                
                for next_id in graph.get(curr_id, []):
                    if next_id in visited:
                        return -1
                    indegrees[next_id] -= 1
                    if indegrees[next_id] == 0:
                        indegrees.pop(next_id)
                        queue.append(next_id)
                        visited.add(next_id)
                
            ans += 1
            
        return ans if len(visited) == n else -1
            
        
