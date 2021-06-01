class Solution:
    def ipToCIDR(self, ip: str, n: int) -> List[str]:
        # 00000000 00000000 00000000 00000000
        # 00000000 00000000 00000000 00000001
        # 00000000 00000000 00000000 00000010
        # 00000000 00000000 00000000 00000011
        ans = []
        x = ip_to_binary(ip)
        while n > 0:
            if x == 0:
                count = math.floor(math.log(n, 2))
                k = 32 - count
                ans.append(f'0.0.0.0/{k}')
                n -= 2 ** count
                x += 2 ** count
            else:
                count = x & (-x)

                while count > n:
                    count //= 2

                ans.append(generate_cidr(x, count))

                n -= count
                x += count
        
        return ans
    
def ip_to_binary(ip):
    x = 0

    for chunk in ip.split('.'):
        x = x * 256 + int(chunk)

    return x

def generate_cidr(x, count):
    chunks = []
    
    for _ in range(4):
        chunks.append(str(x & 255))
        x = x >> 8
    
    length = 0
    while count > 0:
        length += 1
        count = count >> 1
    ip = '.'.join(reversed(chunks))
    k = 32 - length + 1
    return f'{ip}/{k}'
