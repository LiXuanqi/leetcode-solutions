class Codec:
    def encode(self, strs: [str]) -> str:
        """Encodes a list of strings to a single string.
        """
        ans = ''
        return ''.join(
            encode_length(len(word)) + word
            for word in strs
        )

    def decode(self, s: str) -> [str]:
        """Decodes a single string to a list of strings.
        """
        ans = []
        index = 0
        while index < len(s):
            encoded_length = s[index: index + 4]
            length = decode_length(encoded_length)
            index = index + 4
            
            ans.append(s[index: index + length])
            index = index + length
        return ans
        
def encode_length(length):
    bytes = []
    for i in range(4):
        bytes.append(chr(length >> (i * 8) & 0xff))
    bytes.reverse()
    return ''.join(bytes)

def decode_length(s):
    ans = 0
    for c in s:
        ans = ans * 256 + ord(c)
    return ans
        
        


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))
