class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        def order_func(word):
            return -len(word), word
        
        dictionary.sort(key=order_func)
        
        for word in dictionary:
            if match(word, s):
                return word
        return ''
    
def match(word, pattern):
    pointer_1 = 0
    pointer_2 = 0
    n = len(word)
    m = len(pattern)
    while pointer_1 < n and pointer_2 < m:
        if word[pointer_1] == pattern[pointer_2]:
            pointer_1 +=1
        pointer_2 += 1
    
    if pointer_1 == n:
        return True
    return False
                
