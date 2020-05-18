class Solution:
    def encode(self, num: int) -> str:
        length = get_encode_length(num)
        if length == 0:
            return ""
        # print(length)
        res = num - (2 ** length - 1)
        ans = "{0:b}".format(res)
        zero_length = length - len(ans)
        return '0' * zero_length + ans
        
def get_encode_length(num):
    # 2^n-1 <= num
    # 2^n <= num + 1
    return math.floor(math.log(num+1, 2))