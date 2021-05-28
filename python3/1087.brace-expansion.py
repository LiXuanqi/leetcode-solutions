class Solution:
    def expand(self, s: str) -> List[str]:
        groups = []
        curr_group = []
        is_open = False
        for c in s:
            if c == '{':
                is_open = True     
            elif c == '}':
                is_open = False
                groups.append(sorted(curr_group))
                curr_group = []
            elif c == ',':
                continue
            else:             
                if not is_open:
                    groups.append([c])
                else:
                    curr_group.append(c)
        # print(groups)
        ans = []
        
        def dfs(index, temp):
            if index == len(groups):
                ans.append(temp)
                return
            for c in groups[index]:
                dfs(index + 1, temp + c)
        
        dfs(0, '')
        return ans
            
            
        
