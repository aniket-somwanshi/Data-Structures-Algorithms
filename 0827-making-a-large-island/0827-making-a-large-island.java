// O(N*N + N*N) O(N*N) 
// DSU
class Solution {
    private int[][] dirs = new int[][] {
        {0,1},{1,0},{-1,0},{0,-1}
    };
    public int largestIsland(int[][] a) {
        int n = a.length;
        
        DSU dsu = new DSU(n*n+1);
        
        int maxiSize = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) continue;
                
                for (int[] dir: dirs) {
                    int newX = i + dir[0];
                    int newY = j + dir[1];
                    
                    if (newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
                    
                    if (a[newX][newY] == 0) continue;
                    
                    int flatNumber1 = i*n + j;
                    int flatNumber2 = newX*n + newY;
                    dsu.union(flatNumber1, flatNumber2);
                    
                    maxiSize = Math.max(maxiSize, dsu.size[dsu.findParent(flatNumber1)]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) continue;
                
                Set<Integer> set = new HashSet<>();
                int sizeIncrement = 1;
                
                for (int[] dir: dirs) {
                    int newX = i + dir[0];
                    int newY = j + dir[1];
                    
                    if (newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
                    
                    if (a[newX][newY] == 0) continue;
                    
                    int flatNumberNew = newX*n + newY;
                    
                    if (set.contains(dsu.findParent(flatNumberNew))) continue;
                    
                    set.add(dsu.findParent(flatNumberNew));
                    
                    sizeIncrement += dsu.size[dsu.findParent(flatNumberNew)];
    
                }
                
                maxiSize = Math.max(maxiSize, sizeIncrement);
            }
        }
        
        return maxiSize;
    }
}


class DSU {
    private int[] parent;
    public int[] size;
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
        for (int i = 0; i < _size; i++) {
            size[i] = 1;
        }
    }
    
    public void union(int u, int v) {
        unionBySize(u,v);
    }
    
    public boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }
    
    public int findParent(int node) { 
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
