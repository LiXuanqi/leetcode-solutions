class Solution:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        left = 0
        n = len(arr)
        
        dp = [float('inf')] * n
        
        curr_sum = 0
        curr_shortest_len = float('inf')
        
        ans = float('inf')
        
        for right in range(n):
            curr_sum += arr[right]
            while curr_sum > target:
                
                curr_sum -= arr[left]
                left += 1
            
            if curr_sum == target:
                curr_shortest_len = min(curr_shortest_len, right - left + 1)
                if left > 0:
                    ans = min(ans, right - left + 1 + dp[left - 1])
                
            dp[right] = curr_shortest_len
        
        return ans if ans != float('inf') else -1
