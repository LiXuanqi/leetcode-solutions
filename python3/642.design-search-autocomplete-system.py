class TrieNode:
    def __init__(self):
        self.neighbors = {}
        self.count = 0
        
class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        
        self.trie = TrieNode()
        self.curr = self.trie
        self.user_input = ''
        
        for i, sentence in enumerate(sentences):
            self._insert(sentence, times[i])
                    
    def _insert(self, sentence, time): 
        curr = self.trie
        for c in sentence:
            if c not in curr.neighbors:
                curr.neighbors[c] = TrieNode()
            curr = curr.neighbors[c]
        curr.count += time

    def input(self, c: str) -> List[str]:
        if c == '#':
            # insert
            self.curr.count += 1
            self.curr = self.trie
            self.user_input = ''
            return []
        
        else:
            self.user_input += c
            # query
            if c not in self.curr.neighbors:
                self.curr.neighbors[c] = TrieNode()
                
            self.curr = self.curr.neighbors[c]
            
            return self._get_words()
        
    def _get_words(self):
        suffixs = []
        
        def dfs(curr, temp):
            if curr.count > 0:
                suffixs.append((curr.count, temp))
                
            for k ,v in curr.neighbors.items():
                dfs(v, temp + k)
                
        dfs(self.curr, '')
        suffixs.sort(key=lambda k: (-k[0], k[1]))
        ans = [self.user_input + suffix for _, suffix in suffixs]
        if len(ans) >= 3:
            return ans[:3]
        return ans
        
        



# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)
