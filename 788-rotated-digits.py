digits = {
    '0': '0',
    '1': '1',
    '2': '5',
    '5': '2',
    '6': '9',
    '8': '8',
    '9': '6'
}

class Solution:
    def rotatedDigits(self, N: int) -> int:
        count = 0
        for num in range(N + 1):
            if any([c not in digits for c in str(num)]):
                continue
            # - can rotate
            if rotate(num) != num:
                count += 1
        return count
    
def rotate(num):
    num = str(num)
    ans = "".join([digits[c] for c in num])
    return int(ans)
    
        
