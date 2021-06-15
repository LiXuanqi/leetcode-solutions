class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        char_frequency = collections.defaultdict(int)
        left = 0
        curr_unique = 0
        ans = 0
        
        for right, c in enumerate(s):
            char_frequency[c] += 1
            if char_frequency[c] == 1:
                curr_unique += 1
            while left <= right and curr_unique > k:
                char_frequency[s[left]] -= 1
                if char_frequency[s[left]] == 0:
                    curr_unique -= 1
                left += 1
            
            ans = max(ans, (right - left + 1))
            
        return ans
        
