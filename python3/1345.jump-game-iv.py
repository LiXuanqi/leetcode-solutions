class Solution:
    def minJumps(self, arr: List[int]) -> int:
        
        indexes = collections.defaultdict(set)
        for index, num in enumerate(arr):
            indexes[num].add(index)
        
        n = len(arr)
        
        queue = collections.deque()
        visited = set()
        
        queue.append(0)
        visited.add(0)
        
        ans = 0
        
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                if curr == n - 1:
                    return ans
                
                candidates = indexes[arr[curr]]
                candidates.add(curr + 1)
                candidates.add(curr - 1)
                
                for next_index in candidates:
                    if next_index >= 0 and next_index < n and next_index not in visited:
                        queue.append(next_index)
                        visited.add(next_index)
                
                candidates.clear()
                
            ans += 1
            
        return -1
        
