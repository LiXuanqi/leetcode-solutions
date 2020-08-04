class Solution:
    def grayCode(self, n: int) -> List[int]:
        if n == 0:
            return [0]
        init_str = '0' * n
        visited = {init_str}
        ans = []
        dfs(init_str, visited, ans)

        return ans
    
def dfs(s, visited, ans):
    # print(s)
    ans.append(int(s, 2))
    # try to change every character
    for index in range(len(s)):
        next_str = reverse_str_at_index(s, index)
        if next_str not in visited:
            visited.add(next_str)
            dfs(next_str, visited, ans)
            
def reverse_str_at_index(s, index):
    c = '0' if s[index] == '1' else '1'
    return s[:index] + c + s[index + 1:]
