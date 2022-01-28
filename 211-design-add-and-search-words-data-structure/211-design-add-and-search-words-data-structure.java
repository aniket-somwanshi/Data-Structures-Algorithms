class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    public TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return exploreSearch(word, 0, root);
    }
    
    private boolean exploreSearch(String word, int i, TrieNode node) {
        if (i == word.length()) return node.isEnd;
        int index = word.charAt(i) - 'a';
        if (word.charAt(i) != '.') {
            if (node.children[index] != null) {
                return exploreSearch(word, i+1, node.children[index]);
            } 
            else return false;
        }
        else {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null) {
                    if (exploreSearch(word, i+1, node.children[j])) return true;
                }
            }
            return false;
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */