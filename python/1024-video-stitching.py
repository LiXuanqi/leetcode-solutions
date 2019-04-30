class Solution:
    def videoStitching(self, clips: List[List[int]], T: int) -> int:
        if not clips:
            return -1
        
        dp = [[float('inf')] * (T + 1) for _ in range(T)]
        for start, end in clips:
            for i in range(T):
                for j in range(i + 1, T + 1):
                    if start > j or end < i:
                        continue
                    
                    if start <= i and end >= j:
                        # - cover.
                        dp[i][j] = 1
                    elif start <= i and end < j:
                        # - (end, j) need cover.
                        dp[i][j] = min(dp[i][j], dp[end][j] + 1)
                    elif start > i and end >= j:
                        # - (i, start) need cover.
                        dp[i][j] = min(dp[i][j], dp[i][start] + 1)
                    else:
                        dp[i][j] = min(dp[i][j], dp[i][start] + 1 + dp[end][j])
        return dp[0][T] if dp[0][T] != float('inf') else -1
            