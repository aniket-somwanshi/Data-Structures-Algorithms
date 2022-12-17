// O(NlogN + MlogM + N*32 + N*32) O(N*32) N => nums.length, M => queries.length
// Bit manipulation using TRIE
class Query implements Comparable<Query> {
    int originalIndex;
    int num;
    int maxAllowed;
    public Query(int o, int n, int m) {
        originalIndex = o;
        num = n;
        maxAllowed = m;
    }
    
    @Override
    public int compareTo(Query o) {
        return this.maxAllowed - o.maxAllowed;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        
        // sort by max el allowed
        List<Query> q = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            q.add(new Query(i, queries[i][0], queries[i][1]));
        }
        
        Collections.sort(q);
        
        int[] res = new int[queries.length];
        
        Trie trie = new Trie();
        
        int allowedIndex = 0;
    
        // find answer for each query
        // include more elements from nums if they are allowed in this query
        for (Query query: q) {
            while (allowedIndex < nums.length && nums[allowedIndex] <= query.maxAllowed) {
                trie.add(nums[allowedIndex]);
                allowedIndex++;
            }
            // if there are no eligible elements, ans should be -1
            if (allowedIndex == 0) {
                res[query.originalIndex] = -1;
                continue;
            }
            
            // find max XOR
            int ans = trie.getMaxXOR(query.num);
            
            // add ans to res
            res[query.originalIndex] = ans;
        }
        
        return res;
    }
}


class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void add(int num) {
        Node current = root;
        // start adding from the MSB
        for (int i = 31; i >= 0; i--) {
            int currentBit = (num >> i) & 1;
            if (current.children[currentBit] == null) {
                current.children[currentBit] = new Node();
            }
            current = current.children[currentBit];
        }
    }
    
    public int getMaxXOR(int queryNum) {
        Node current = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int queryNumMSB = (queryNum >> i) & 1;
            int targetBit = 1-queryNumMSB; // flip
            // we either find this target bit or we don't 
            // if we find it add 1 on the MSB of result XOR
            // else 0
            if (current.children[targetBit] != null) {
                res = res | (1 << i);
                current = current.children[targetBit];
            }
            else {
                current = current.children[queryNumMSB]; // settle for this bit
            }
        }
        return res;
    }
}

class Node {
    Node[] children;
    public Node() {
        children = new Node[2]; // [0,1]
    }
}







