class Solution:
    def canMeasureWater(self, jug1Capacity: int, jug2Capacity: int, targetCapacity: int) -> bool:
        start = (0, 0)
        queue = collections.deque()
        visited = set()
        
        queue.append(start)
        visited.add(start)
        
        while queue:
            curr = queue.popleft()
            if (
                curr[0] + curr[1] == targetCapacity or
                curr[0] == targetCapacity or
                curr[1] == targetCapacity
            ):
                return True
            
            operations = []
            # Fill any of the jugs with water.
            operations.append((jug1Capacity, curr[1]))
            operations.append((curr[0], jug2Capacity))
            
            # Empty any of the jugs.
            operations.append((0, curr[1]))
            operations.append((curr[0], 0))
            
            # Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
            # pour #1 to #2
            if curr[0] <= jug2Capacity - curr[1]:
                operations.append((0, curr[0] + curr[1]))
            else:
                operations.append((curr[0] - (jug2Capacity - curr[1]), jug2Capacity))
            # pour #2 to #1
            if curr[1] <= jug1Capacity - curr[0]:
                operations.append((curr[0] + curr[1], 0))
            else:
                operations.append((jug1Capacity, curr[1] - (jug1Capacity - curr[0])))
            
            for operation in operations:
                if operation not in visited:
                    queue.append(operation)
                    visited.add(operation)
            
        return False
        
