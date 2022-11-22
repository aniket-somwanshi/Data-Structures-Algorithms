// O(N*32 + N*32) O(2^32 - 1) -- bit manipulation + Trie
class Node {
    Node[] child;
    public Node() {
        child = new Node[2];    
    }
}

class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(int num) {
        Node current = root;
        // insert binary of this num into trie
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            
            if(current.child[bit] == null) current.child[bit] = new Node();
            current = current.child[bit];
        }
    }
    
    public int getMaxXORWith(int num) {
        int maxiRes = 0; 
        Node current = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int requiredBit = 1 - bit;
            if (current.child[requiredBit] != null) {
                // set this bit to 1 in our ans
                maxiRes = maxiRes | (1 << i);
                // go into this path
                current = current.child[requiredBit];
            }
            else {
                current = current.child[bit];
            }
        }
        return maxiRes;
    }
}

class Solution {
    public int findMaximumXOR(int[] a) {
        int n = a.length;
        Trie trie = new Trie();
        for (int num: a) {
            trie.insert(num);
        }
        
        int maxi = 0;
        for (int num: a) {
            maxi = Math.max(maxi, trie.getMaxXORWith(num));
        }
        return maxi;
    }
}