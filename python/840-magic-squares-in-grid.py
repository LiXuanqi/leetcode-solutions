class Solution(object):
    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or len(grid) == 0 or len(grid[0]) == 0:
            return 0
        count = 0
        for i in range(len(grid) - 2):
            for j in range(len(grid[0]) - 2):
                if isMagicSquare(i, j, grid):
                    count += 1              
        return count
    
def isMagicSquare(startX, startY, grid):
    nums = set()
    # - check row and col
    for i in range(3):
        sum1 = 0
        sum2 = 0
        for j in range(3):
            sum1 += grid[startX + i][startY + j]
            sum2 += grid[startX + j][startY + i]
            num = grid[startX + i][startY + j] 
            if num < 1 or num > 9:
                return False
            nums.add(num)
        if sum1 != sum2:
            return False
    if len(nums) != 9:
        return False
    diag1 = grid[startX][startY] +  grid[startX + 1][startY + 1] +  grid[startX + 2][startY + 2]
    diag2 = grid[startX][startY + 2] +  grid[startX + 1][startY + 1] +  grid[startX + 2][startY]
    if diag1 != diag2:
        return False
    return True
    