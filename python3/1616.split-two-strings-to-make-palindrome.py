# Greedy
class Solution:
    def checkPalindromeFormation(self, a: str, b: str) -> bool:
        return check(a, b) or check(b, a)
    
def check(a, b):
    len_palindrom = get_longest_palindrome_len(a, b)
    
    return is_palindrome(a[len_palindrom:len(a)-len_palindrom]) or is_palindrome(b[len_palindrom:len(a)-len_palindrom])

def get_longest_palindrome_len(a, b):
    index = 0
    while index < len(a) and a[index] == b[-index - 1]:
        index += 1
    return index

def is_palindrome(s):
    # print(s)
    left = 0
    right = len(s) - 1
    while left <= right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1
    return True
        
