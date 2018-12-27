class Trie {
    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> edges;
        public TrieNode() {
            isWord = false;
            edges = new HashMap<>();
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.edges.containsKey(word.charAt(i))) {
                curr.edges.put(word.charAt(i), new TrieNode());
            }
            curr = curr.edges.get(word.charAt(i));
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.edges.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.edges.get(word.charAt(i));
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!curr.edges.containsKey(prefix.charAt(i))) {
                return false;
            }
            curr = curr.edges.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */