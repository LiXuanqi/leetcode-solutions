class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        ans = []
        
        comment_block_open = False
        buffer = ''
        
        for line in source:
            i = 0
            while i < len(line):
                # //
                if line[i] == '/' and i + 1 < len(line) and line[i + 1] == '/' and not comment_block_open:
                    i = len(line) - 1
                elif line[i] == '/' and i + 1 < len(line) and line[i + 1] == '*' and not comment_block_open:
                    
                    comment_block_open = True
                    i += 1
                elif line[i] == '*' and i + 1 < len(line) and line[i + 1] == '/' and comment_block_open:
          
                    comment_block_open = False
                    i += 1
                elif not comment_block_open:
                    buffer += line[i]
                    
                i += 1
          
            if not comment_block_open and buffer:
                ans.append(buffer)
                buffer = ''
                
        return ans
    
            
        
