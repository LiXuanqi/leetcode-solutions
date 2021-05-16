class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
        max_len = 0
        
        path_length = {0: 0}
        
        for row in input.split('\n'):
     
            path = row.lstrip('\t')
      
            depth = len(row) - len(path)
    
            if '.' in path:
                max_len = max(max_len, path_length[depth] + len(path))
            else:
                path_length[depth + 1] = path_length[depth] + len(path) + 1
        
        return max_len
