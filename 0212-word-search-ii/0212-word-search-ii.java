class TrieNode {
    TrieNode[] children;
    int countOfWords; // count of words containing this letter
    int countOfWordsEndingHere; // count of words ending at this letter
    public TrieNode() {
        children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i)-'a'] == null) {
                current.children[word.charAt(i)-'a'] = new TrieNode();
            }
            current = current.children[word.charAt(i)-'a'];
            current.countOfWords++;
        }
        current.countOfWordsEndingHere++;
    }
    
}

class Solution {
    int[][] dirs = new int[][] {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        
        Trie trie = new Trie();
        for (String word: words) trie.insert(word);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.children[board[i][j]-'a'] != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(board[i][j]);
                    
                    char ogValue = board[i][j];
                    board[i][j] = 'X';
                    
                    dfs(i, j, board, sb, trie.root.children[ogValue-'a'], res);
                    
                    board[i][j] = ogValue;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        
        return new ArrayList<>(res);
    }
    
    private void dfs(int i, int j, char[][] a, StringBuilder current, TrieNode trieNode, Set<String> res) {
        // if we have reached the end of any of the string in trieNode, 
        // we know it is present, so add it to result
        if (trieNode.countOfWordsEndingHere > 0) res.add(current.toString());
        // continue this path, cos there might be a longer word that's present as well
        
        for (int[] dir: dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            
            if (newX < 0 || newY < 0 || newX >= a.length || newY >= a[0].length) continue;
            
            if (a[newX][newY] == 'X') continue;
                        
            char currentChar = a[newX][newY];
            if (trieNode.children[currentChar-'a'] != null) {
                current.append(currentChar);
                // mark this character as visited, so that we don't use it again later
                char ogValue = a[newX][newY];
                a[newX][newY] = 'X';
                dfs(newX, newY, a, current, trieNode.children[ogValue-'a'], res);
                // backtrack
                a[newX][newY] = ogValue; // re-assign the ogValue back
                current.deleteCharAt(current.length()-1); // remove the last added char from current string
            }
        }

    }
    
}