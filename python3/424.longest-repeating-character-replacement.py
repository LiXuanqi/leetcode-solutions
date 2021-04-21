class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        left = 0
        frequencies = collections.defaultdict(int)
        
        max_count = 0
        
        ans = 0
        
        for right, c in enumerate(s):
            frequencies[c] += 1
            max_count = max(max_count, frequencies[c])
            
            if right - left + 1 - max_count > k:
                frequencies[s[left]] -= 1
                left += 1
                
            curr_len = right - left + 1
            ans = max(ans, curr_len)
            
        return ans
            
