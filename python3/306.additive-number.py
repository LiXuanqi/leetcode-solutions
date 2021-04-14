class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        n = len(num)
        # once the first two is decided, the rest is fixed.
        for i in range(1, n - 1):
            for j in range(i + 1, n):
                first_num = str_to_int(num[:i])
                second_num = str_to_int(num[i:j])
                if validate(first_num, second_num, num[j:]):
                    return True
        return False
        

def validate(first, second, num):
    # print(first, second, num)
    if num == '':
        return True
    if first is None or second is None:
        return False
    target = first + second
    n = len(str(target))
    if str_to_int(num[:n]) != target:
        return False
    return validate(second, target, num[n:])
        
def str_to_int(s):
    if len(s) != 1 and s.startswith('0'):
        return None
    return int(s)