class Solution:
    def jump(self, nums: List[int]) -> int:
        # - bfs
        if not nums:
            return -1
        if len(nums) <= 1:
            return 0
        visited = [False] * len(nums)
        queue = collections.deque()
        queue.append(0)
        visited[0] = True
        ans = 0
        while queue:
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                # - neighbbors
                for step in reversed(range(1, nums[curr] + 1)):
                    next = curr + step
                    if next >= len(nums) - 1:
                        return ans + 1
                    if not visited[next]:
                        queue.append(next)
                        visited[next] = True
            ans += 1
        return ans
        