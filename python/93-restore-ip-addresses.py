class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        if not s or len(s) > 12:
            return []
        ans = []
        
        def isValid(string):
            if len(string) > 1 and string[0] == "0":
                return False
            if 0 <= int(string) <= 255:
                return True
            return False
        
        def dfs(s, start, temp, level):
            if level > 4:
                return
            if start >= len(s):
                if level == 4:
                    ans.append(temp[1:])
                return
            for length in range(3):
                end = start + 1 + length
                if end <= len(s):
                    substr = s[start: end]
                    if isValid(substr):
                        dfs(s, end, temp + "." + substr, level + 1)
            
        dfs(s, 0, "", 0)
        return ans

    
        