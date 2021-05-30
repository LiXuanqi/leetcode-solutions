class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        stations.sort(key=lambda s: -s[0])
        
        queue = collections.deque()
        queue.append(startFuel)
        
        ans = 0
        
        can_fuel_stations = []
        
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                if curr >= target:
                    return ans
                while stations and stations[-1][0] <= curr:
                    heapq.heappush(can_fuel_stations, -stations.pop()[1])
                if can_fuel_stations:
                    queue.append(curr + (-heapq.heappop(can_fuel_stations)))
            ans += 1
        return -1
        
        
