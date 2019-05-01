class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n <= 0:
            return 0
        pq = [1]
        seen = {1}
        while n > 1:
            num = heapq.heappop(pq)
            n -= 1
            for factor in (2, 3, 5):
                next = num * factor
                if next not in seen:
                    heapq.heappush(pq, next)
                    seen.add(next)
        return heapq.heappop(pq)
        