class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        ans = ""
        target = 'a' + target
        for i in range(1, len(target)):
            first = target[i - 1]
            second = target[i]
            ans += move(first, second)
        return ans
            
            
def move(start, end):
    start_y, start_x = get_pos(start)
    end_y, end_x = get_pos(end)
    diff_y = start_y - end_y
    diff_x = start_x - end_x
    diff_y_str = ('D' if diff_y < 0 else 'U') * abs(diff_y)
    diff_x_str = ('R' if diff_x < 0 else 'L') * abs(diff_x)
    # 'z' is special, can't move out of board.
    return ((diff_x_str + diff_y_str) if diff_y < 0 else (diff_y_str + diff_x_str)) + '!'
        
def get_pos(c):
    num = ord(c) - ord('a')
    # board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]
    # there are 5 characters each row
    return num // 5, num % 5
