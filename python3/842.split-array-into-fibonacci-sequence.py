class Solution:
    def splitIntoFibonacci(self, S: str) -> List[int]:
        # When the first two numbers are decided,
        # all next numbers are decided too.

        for i in range(1, len(S) - 1):
            # need have at least 1 chracter left for third number
            for j in range(i + 1, len(S)):
                first = to_number(S[:i])
                second = to_number(S[i:j])
                ans = [first, second]
                if is_valid_fibonacci(S, j, first, second, ans):
                    return ans
        return []
        
def to_number(s):
    # print(s)
    num = int(s)
    if s.startswith('0') and num != 0:
        return None
    if num < 0 or num > 2 ** 31 - 1:
        return None
    return num

def is_valid_fibonacci(s, curr_index, first, second, ans):
    if first is None or second is None:
        return False
    if curr_index == len(s):
        return True
    expected = first + second
    len_next_num = len(str(expected))
    end_index = curr_index + len_next_num
    next_num = to_number(s[curr_index: end_index])
    if next_num != expected:
        return False
    ans.append(next_num)
    return is_valid_fibonacci(s, end_index, second, next_num, ans)
