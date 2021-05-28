class Solution:
    def findReplaceString(self, S: str, indexes: List[int], sources: List[str], targets: List[str]) -> str:
        n = len(S)
        
        indexes = {
            index: pos
            for pos, index in enumerate(indexes)
        }
        
        need_replace = [0] * n
        
        for i in range(n):
            if i in indexes:
                source = sources[indexes[i]]
                if can_match(S, i, source):
                    need_replace[i] = len(source)
  
        # print(need_replace)

        ans = ''
   
        i = 0
        while i < n:
            if need_replace[i] > 0:
                ans += targets[indexes[i]]
         
                skip_time = need_replace[i]
                while i < n and skip_time > 0:
                    skip_time -= 1
                    i += 1
            else:
                ans += S[i]
                i += 1
        return ans
            
        
def can_match(s, start_index, source):
    
    for i in range(len(source)):
        if s[start_index + i] != source[i]:
            return False
    return True

# "vmokgggqzp"
# [3,5,1]
# ["kg","ggq","mo"]
# ["s","so","bfr"]
                
        
