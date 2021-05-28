class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        trie = Trie()
        
        ans = []
        
        raw_palindrome_indexes = get_raw_palindrome_indexes(words)
        
        for index, word in enumerate(words):
            if word == '':
                for another_index in raw_palindrome_indexes:
                    if index != another_index:
                        ans.append([index, another_index])
                        ans.append([another_index, index])
            else:
                trie.add_word(word[::-1], index)
            
        for index, word in enumerate(words):
            for another_index in trie.starts_with(word):
                if index != another_index:
                    ans.append([index, another_index])
        
        return ans
        
 
class TrieNode:
    def __init__(self):
        self.neighbors = {}
        self.word_index = None
        self.bellow_palindrom_word_indexes = []

class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def add_word(self, word, word_index):
        curr = self.root
        for index, c in enumerate(word):
            if c not in curr.neighbors:
                curr.neighbors[c] = TrieNode()
            curr = curr.neighbors[c]
            
            suffix = word[index + 1:]
            if suffix and is_palindrom(suffix):
                curr.bellow_palindrom_word_indexes.append(word_index)
                
        curr.word_index = word_index
        
    def starts_with(self, prefix):
        curr = self.root
        
        ans = []
        
        for index, c in enumerate(prefix):
            if c not in curr.neighbors:
                return ans
            curr = curr.neighbors[c]
            if curr.word_index is not None and is_palindrom(prefix[index + 1:]):
                ans.append(curr.word_index)
        
        ans.extend(curr.bellow_palindrom_word_indexes)
        
        return ans
                
        
def is_palindrom(word):
    left = 0
    right = len(word) - 1
    
    while left <= right:
        if word[left] != word[right]:
            return False
        left += 1
        right -= 1
    return True

def get_raw_palindrome_indexes(words):
    ans = []
    for index, word in enumerate(words):
        if word and is_palindrom(word):
            ans.append(index)
            
    return ans
            
        
