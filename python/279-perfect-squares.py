class Solution:
    def numSquares(self, n: int) -> int:
        perfectNums = [i * i for i in range(1, int(math.sqrt(n)) + 1)]
        # bfs
        queue = collections.deque()
        seen = set()
        queue.append(n)
        seen.add(n)
        level = 0
        while queue:
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                if curr == 0:
                    return level
                for num in perfectNums:
                    next = curr - num
                    if next not in seen and next >= 0:
                        queue.append(next)
                        seen.add(next)
            level += 1
        return level
        