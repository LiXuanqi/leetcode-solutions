class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        n = len(tasks)
        # sort by time
        tasks = sorted([(task[1], index, task[0]) for index, task in enumerate(tasks)], key=lambda task: task[2])
        
        curr_time = tasks[0][2]
        
        ans = []
        count = 0
        time_index = 0
        
        heap = []
        
        while count < n:
            while time_index < n and tasks[time_index][2] <= curr_time:
                heapq.heappush(heap, tasks[time_index])
                time_index += 1
           
            if not heap:
                # go to next time
                curr_time = tasks[time_index][2]
                continue
            curr_task = heapq.heappop(heap)
            
            ans.append(curr_task[1])
            count += 1
            curr_time += curr_task[0]
            
        return ans
        
        
