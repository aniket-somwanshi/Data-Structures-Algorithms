class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    public TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        int i = 0;
        while (i < word.length()) {
            if (current.child[word.charAt(i)-'a'] == null) {
                current.child[word.charAt(i)-'a'] = new TrieNode();
            }
            current = current.child[word.charAt(i)-'a'];
            i++;
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        int i = 0;
        while (i < word.length() && current.child[word.charAt(i)-'a'] != null) {
            current = current.child[word.charAt(i++)-'a'];
        }
        return i == word.length() && current.isEnd;
    }
    
    public boolean startsWith(String word) {
        TrieNode current = root;
        int i = 0;
        while (i < word.length() && current.child[word.charAt(i)-'a'] != null) {
            current = current.child[word.charAt(i++)-'a'];
        }
        return i == word.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */