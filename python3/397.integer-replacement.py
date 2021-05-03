class Solution:
    def integerReplacement(self, n: int) -> int:
        queue = collections.deque([n])
        visited = set([n])
        ans = 0
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                if curr == 1:
                    return ans
                if curr % 2 == 0:
                    next_nums = [curr // 2]
                else:
                    next_nums = [curr + 1, curr - 1]
                for num in next_nums:
                    if num not in visited:
                        queue.append(num)
                        visited.add(num)
                        
            ans += 1
            
        return -1
            
        
        