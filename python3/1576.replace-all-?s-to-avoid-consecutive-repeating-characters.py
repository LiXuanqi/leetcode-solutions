class Solution:
    def modifyString(self, s: str) -> str:
        prev = '?'
        
        ans = ''
        
        for index, c in enumerate(s):
            next = s[index + 1] if index + 1 < len(s) else '?'
            valid_char = ({'a', 'b', 'c'} - {prev, next}).pop()
            prev = (valid_char if c == '?' else c)
            ans += prev
        return ans
    
    
                
        
