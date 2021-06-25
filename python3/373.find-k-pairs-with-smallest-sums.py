class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        ans = []
        visited = set()
        heap = [(0 ,0, 0)]
        for _ in range(k):
            if not heap:
                return ans
            _, i, j = heapq.heappop(heap)
            ans.append([nums1[i], nums2[j]])
            if i + 1 < len(nums1) and (i + 1, j) not in visited:
                heapq.heappush(heap, (nums1[i + 1] + nums2[j], i + 1, j))
                visited.add((i + 1, j))
            if j + 1 < len(nums2) and (i, j + 1) not in visited:
                heapq.heappush(heap, (nums1[i] + nums2[j + 1], i, j + 1))
                visited.add((i, j + 1))
        return ans
            
            
        
