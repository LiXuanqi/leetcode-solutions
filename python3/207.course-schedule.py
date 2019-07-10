from collections import deque
class Solution:
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if numCourses <= 0 or not prerequisites or len(prerequisites) == 0:
            return True
        graph = buildGraph(prerequisites)
        # - count indegrees
        indegrees = {}
        for k, courses in graph.items():
            for course in courses:
                indegrees[course] = indegrees.get(course, 0) + 1
        # - bfs
        queue = deque()
        visited = [False] * numCourses
        for i in range(numCourses):
            if i not in indegrees:
                queue.append(i)
                visited[i] = True
        while queue:
            curr = queue.popleft()
            if curr in graph:
                for next in graph.get(curr):
                    indegrees[next] = indegrees[next] - 1
                    if indegrees[next] == 0:
                        queue.append(next)
                        visited[next] = True
        for visit in visited:
            if not visit:
                return False
        return True

    
def buildGraph(prerequisites):
    graph = {}
    for prerequisite in prerequisites:
        if prerequisite[1] not in graph:
            graph[prerequisite[1]] = []
        graph[prerequisite[1]].append(prerequisite[0])
    return graph