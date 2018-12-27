class WordDictionary {
    
    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> edges = new HashMap<>();
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] str = word.toCharArray();
        TrieNode curr = root;
        for (char c : str) {
            while (!curr.edges.containsKey(c)) {
                curr.edges.put(c, new TrieNode());
            }
            curr = curr.edges.get(c);
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(word, 0, root);
    }
    private boolean isMatch(String word, int index, TrieNode node) {
        if (word.length() <= index) {
            if (node.isWord) {
                return true;
            } else {
                return false;
            }
        }
        if (word.charAt(index) == '.') {
            boolean isValid = false;
            for (TrieNode edge : node.edges.values()) {
                if (isMatch(word, index + 1, edge)) {
                    isValid = true;
                }
            }
            return isValid;
        } else {
            if (node.edges == null || !node.edges.containsKey(word.charAt(index))) {
                return false;
            }
            return isMatch(word, index + 1, node.edges.get(word.charAt(index)));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */