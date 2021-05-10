class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        jobs = list(zip(startTime, endTime, profit))
        jobs.sort(key=lambda job: job[1])
        end_times = [job[1] for job in jobs]
        n = len(startTime)
        dp = [0] * n
        for i in range(n):
            start, end, val = jobs[i]
            
            take = dp[bisect.bisect_right(end_times, start) - 1] + val   
            not_take = dp[i - 1] 
         
            dp[i] = max(take, not_take)
           
        # print(dp)
        return max(dp)