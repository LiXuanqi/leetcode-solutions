class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        jobs = zip(difficulty, profit)
        jobs = sorted(jobs, key=lambda j: j[0])
        ans = 0
        i = 0
        best = 0
        for w in sorted(worker):
            while i < len(jobs) and jobs[i][0] <= w:
                best = max(best, jobs[i][1])
                i += 1
            ans += best
        return ans
