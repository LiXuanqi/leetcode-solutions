# If n is len of s, m is total len of words
# Time: O(m + n)
class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        waiting_match = collections.defaultdict(list)
        for word in words:
            waiting_match[word[0]].append(iter(word[1:]))
              
        for c in s:
            for iterator in waiting_match.pop(c, []):
                waiting_match[next(iterator, None)].append(iterator)
               
                
        return len(waiting_match[None])
                        
        return ans
    
# Binary Search:
# Time: O(mlogn)
class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        char_position = collections.defaultdict(list)
        for index, c in enumerate(s):
            char_position[c].append(index)
        
        ans = 0
        
        for word in words:
            if check_word(word, char_position):
                ans += 1
                
        return ans
    
def check_word(word, char_position):
    last_index = -1
    for c in word:
        index = find_char_after_index(c, last_index, char_position)
        if index is None:
            return False
        last_index = index
    
    return True

def find_char_after_index(c, last_index, char_position):
    positions = char_position.get(c, [])
    
    if not positions:
        return None
    
    left = 0
    right = len(positions) - 1
    
    while left + 1 < right:
        mid = (left + right) // 2
        if positions[mid] <= last_index:
            left = mid
        else:
            right = mid
            
    if positions[left] > last_index:
        return positions[left]
    if positions[right] > last_index:
        return positions[right]
    
    return None
