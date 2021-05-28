class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        n = len(s)
        ans = 0
        for max_unique in range(1, 27):
            
            counts = collections.defaultdict(int)
            no_less_than_k = 0
            unique = 0
            
            left = 0
            for right in range(n):
                c = s[right]
              
                counts[c] += 1
                if counts[c] == 1:
                    unique += 1
                if counts[c] == k:
                    no_less_than_k +=1
                    
                while unique > max_unique and left < right:
                    c = s[left]
                    counts[c] -= 1
                    left += 1
                    if counts[c] == k - 1:
                        no_less_than_k -= 1
                    if counts[c] == 0:
                        unique -= 1
                
                if no_less_than_k == max_unique:
                    ans = max(ans, right - left + 1)           
        return ans
                
                
                
                
        