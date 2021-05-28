class StreamChecker:

    def __init__(self, words: List[str]):
        self.root = TrieNode()
        self.user_input = []
        for word in words:
            self._insert(word[::-1])
        
        
    def _insert(self, word):
        curr = self.root
        for c in word:
            if c not in curr.neighbors:
                curr.neighbors[c] = TrieNode()
            curr = curr.neighbors[c]
        curr.is_word = True
        

    def query(self, letter: str) -> bool:
        self.user_input.append(letter)

        i = len(self.user_input) - 1
        curr = self.root
        while i >= 0:
            c = self.user_input[i]
            if c not in curr.neighbors:
                return False
            curr = curr.neighbors[c]
            if curr.is_word:
                return True
            i -= 1
        return False
                
            
            
        
        
        

class TrieNode:
    def __init__(self):
        self.neighbors = {}
        self.is_word = False
        
# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)