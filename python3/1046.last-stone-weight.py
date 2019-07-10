class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if not stones:
            return 0
        heap = [(-stone, stone) for stone in stones]
        heapq.heapify(heap)
        while len(heap) > 1:
            first = heap[0]
            heapq.heappop(heap)
            second = heap[0]
            heapq.heappop(heap)
            diff = first[1] - second[1]
            if diff != 0:
                heapq.heappush(heap, (-diff, diff))
        return 0 if len(heap) == 0 else heap[0][1]
            
        