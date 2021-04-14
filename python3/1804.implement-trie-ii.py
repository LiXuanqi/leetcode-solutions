class TrieNode:
    def __init__(self):
        self.word_num = 0
        self.neighbors = {}

class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if c not in curr.neighbors:
                curr.neighbors[c] = TrieNode()
            curr = curr.neighbors[c]
        curr.word_num += 1   

    def countWordsEqualTo(self, word: str) -> int:
        curr = self.root
        for c in word:
            if c not in curr.neighbors:
                return 0
            curr = curr.neighbors[c]
        return curr.word_num
        
    def countWordsStartingWith(self, prefix: str) -> int:
        curr = self.root
        for c in prefix:
            if c not in curr.neighbors:
                return 0
            curr = curr.neighbors[c]
        return self._count_words(curr)
        
    def _count_words(self, curr):
        ans = curr.word_num
        for neighbor in curr.neighbors:
            ans += self._count_words(curr.neighbors[neighbor])
        return ans
        

    def erase(self, word: str) -> None:
        curr = self.root
        for c in word:
            if c not in curr.neighbors:
                return
            curr = curr.neighbors[c]
        curr.word_num -= 1
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.countWordsEqualTo(word)
# param_3 = obj.countWordsStartingWith(prefix)
# obj.erase(word)
