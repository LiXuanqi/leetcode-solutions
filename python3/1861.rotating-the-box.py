class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        n, m = len(box), len(box[0])
        
        for row in box:
            move_position = m - 1
            for j in range(m - 1, -1, -1):
                if row[j] == '*':
                    move_position = j - 1
                elif row[j] == '#':
                    swap(row, move_position, j)
                    move_position -= 1

        return rotate_90(box)

def swap(row, i, j):
    temp = row[i]
    row[i] = row[j]
    row[j] = temp
    
def rotate_90(box):
    n, m = len(box), len(box[0])
    
    ans = [[None] * n for _ in range(m)]
    
    for x in range(n):
        for y in range(m):
            ans[y][n - 1 - x] = box[x][y]
            
    return ans
            
    
    

    
        
        
        
    
    
    
            
    
