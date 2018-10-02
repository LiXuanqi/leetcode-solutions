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
        if (word == null) {
            return;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.edges.containsKey(c)) {
                curr.edges.put(c, new TrieNode());
            } 
            curr = curr.edges.get(c);
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    private boolean match(String word, int index, TrieNode root) {
        if (index == word.length() && root.isWord) {
            return true;
        }
        if (index >= word.length()) {
            return false;
        }
        if (word.charAt(index) == '.') {
            List<TrieNode> nodes = new ArrayList<>(root.edges.values());
            boolean isValid = false;
            for (int i = 0; i < nodes.size(); i++) {
                if (match(word, index + 1, nodes.get(i))) {
                    isValid = true;
                }
            }
            return isValid;
        } else {
            if (!root.edges.containsKey(word.charAt(index))) {
                return false;
            }
            return match(word, index + 1, root.edges.get(word.charAt(index)));
        }

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */