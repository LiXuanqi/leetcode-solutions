# Solution 1:
class Solution:
    def expressiveWords(self, S: str, words: List[str]) -> int:
        unique_keys_s, lens_s = compress_word(S)
        
        ans = 0
        
        for word in words:
            unique_keys_w, lens_w = compress_word(word)
            if unique_keys_s == unique_keys_w:
                
                is_valid = True
                for i in range(len(lens_s)):
                    if (
                        lens_s[i] < lens_w[i]
                        or (lens_s[i] > lens_w[i] and lens_s[i] < 3)
                    ):
                        is_valid = False
                        
                if is_valid:
                    ans += 1
                    
        return ans
                        
def compress_word(word):
    unique_keys = []
    group_lens = []
    for k, group in itertools.groupby(word):
        unique_keys.append(k)
        group_lens.append(len(list(group)))
        
    return unique_keys, group_lens


# Solution 2:
class Solution:
    def expressiveWords(self, S: str, words: List[str]) -> int:
        ans = 0
        for word in words:
            if is_stretchy(word, S):
                ans +=1
                
        return ans
    
def is_stretchy(word, s):
    i = 0
    j = 0
    while i < len(word) and j < len(s):
        if word[i] != s[j]:
            return False
        else:
            # count and skip the same characters
            count_i = 1
            while i + 1 < len(word) and word[i + 1] == word[i]:
                i += 1
                count_i += 1
            count_j = 1
            while j + 1 < len(s) and s[j + 1] == s[j]:
                j += 1
                count_j += 1
            if count_i > count_j:
                return False
            elif count_i < count_j and count_j <= 2:
                return False
            else:
                i += 1
                j += 1
    return i == len(word) and j == len(s)      
                
                
            
        
