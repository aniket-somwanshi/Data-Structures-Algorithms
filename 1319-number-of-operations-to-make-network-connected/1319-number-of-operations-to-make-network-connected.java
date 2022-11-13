class Solution {
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int count = 0;
        if (connections.length < n-1) return -1;
        
        for (int[] c: connections) {
            dsu.union(c[0], c[1]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!dsu.isConnected(i, 0)) {
                count++;
                dsu.union(i, 0);
            }
        }
        return count;
    }
}

class DSU {
    private int[] parent;
    private int[] size;
    private int[] rank;
    
    // constructor
    public DSU (int _size) {
        // initialize number of elements
        // these elements will be in separate components
        this.parent = new int[_size];
        this.size = new int[_size];
        this.rank = new int[_size];
        
        for (int i = 0; i < _size; i++) {
            parent[i] = i;
        }
    }
    
    public void union(int u, int v) {
        unionBySize(u,v);
    }
    
    public boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }
    
    private int findParent(int node) { 
        // if we are at the ultimate parent 
        // here node's parent will be itself
        if (parent[node] == node) return node;
        // else return parent of node until we reach ultimate parent
        // also do path compression, 
        // by setting each node's parent to the ultimate parent 
        return parent[node] = findParent(parent[node]);
    } 
    
    public void unionBySize(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        
        // if both alredy belong to same component no need to combine
        if (parent1 == parent2) return;
        
        // union by size
        // attach smaller size tree to bigger size tree
        // so that lesser new nodes need to find their ultimate parents
        if (size[parent1] < size[parent2]) {
            parent[parent1] = parent2;
            // update size of parent2 ie bigger one
            size[parent2] += size[parent1];
        }
        else {
            parent[parent2] = parent1;
            // update size of parent1 ie bigger one
            size[parent1] += size[parent2];
        }
    }
    
    void unionByRank(int node1, int node2) {
		int parent1 = findParent(node1); 
		int parent2 = findParent(node2); 
		if(parent1 == parent2) {
			return; 
		}
 
		// parent1 is smaller 
		// parent1 will attach to parent2
		if(rank[parent1] < rank[parent2]) {
			parent[parent1] = parent2; 
		}
		else if(rank[parent2] < rank[parent1]){
			parent[parent2] = parent1; 
		}
		// rank is equal, attach any one to any one 
        // and increase rank by one
		else {
			parent[parent1] = parent2;
			rank[parent2]++; 
		}
	}
    
}