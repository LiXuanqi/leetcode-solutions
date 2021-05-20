class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> List[int]:
        
        buckets = [[] for _ in range(2001)]
        
        for worker_id, worker in enumerate(workers):
            for bike_id, bike in enumerate(bikes):
                buckets[get_distance(worker, bike)].append((worker_id, bike_id))
                
        
        ans = [None] * len(workers)
        
        assigned_workers = set()
        assigned_bikes = set()
             
        for bucket in buckets:
            for worker_id, bike_id in bucket:
                if worker_id not in assigned_workers and bike_id not in assigned_bikes:
                    ans[worker_id] = bike_id
                    assigned_workers.add(worker_id)
                    assigned_bikes.add(bike_id)

        return ans
                  
def get_distance(worker, bike):
    return abs(worker[0] - bike[0]) + abs(worker[1] - bike[1])
