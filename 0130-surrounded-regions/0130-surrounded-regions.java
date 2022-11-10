// O(2(M*N)) O(M*N) -- union find dsu
// a 0 is protected if it's a boundary node
// we will connect all boundary 0s to a dummy protected node
// and we will connect all boundary 0s to adjacent their 0 regions
// so the middle 0s will also indirectly get connected to 
// the dummy protected node, if they are adjacent to a border node
// so at the end, we traverse again and for every 0 we just check
// if this is connected to that dummy protected node, then we leave it 
// else attack it with 'X' 
class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int rows;
    int cols;
    public void solve(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        
        int dummyProtected = rows*cols;
        
        DSU dsu = new DSU(dummyProtected+1);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == rows-1 || j == cols-1)) {
                    // boundary 0
                    // connect it with a dummy protected node
                    dsu.union(getSingular(i, j), dummyProtected);
                }
                else if (board[i][j] == 'O'){
                    // middle nodes
                    for (int[] dir: dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (board[x][y] == 'O') dsu.union(getSingular(i, j), getSingular(x, y));
                    }
                }
            }
        }
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !dsu.isConnected(getSingular(i, j), dummyProtected)) {
                    board[i][j] = 'X';
                }       
            }
        }
        
    }
            
    private int getSingular(int i, int j) {
        return i * cols + j;
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


// // O(2(M*N)) O(M*N) -- space can be made O(4) by using BFS instead of dfs
// // all the border 0s are protected from the attack.
// // also the regions which are attached to a border 0 are protected
// // so traverse all the border 0s
// // and run dfs from each of them, to further protect the 
// // regions which they are adjacent to.
// // we mark the protected cells as 'P'
// // finally we traverse again and attack the naive 'O's with 'X's
// // and leave the protected 'O's ie 'P's
// class Solution {
//     int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//     public void solve(char[][] board) {
//         int rows = board.length;
//         int cols = board[0].length;
        
//         // travserse borders
//         for (int i = 0; i < rows; i++) {
//             if (board[i][0] == 'O') {
//                 populateProtectedCells(i, 0, board);    
//             }
//             if (board[i][cols-1] == 'O') {
//                 populateProtectedCells(i, cols-1, board);    
//             } 
//         }
        
//         for (int j = 0; j < cols; j++) {
//             if (board[0][j] == 'O') {
//                 populateProtectedCells(0, j, board);    
//             }
//             if (board[rows-1][j] == 'O') {
//                 populateProtectedCells(rows-1, j, board);    
//             } 
//         } 
        
//         for (int i = 0; i < rows; i++) {
//              for (int j = 0; j < cols; j++) {
//                  if (board[i][j] == 'P') board[i][j] = 'O';
//                  else if (board[i][j] == 'O') board[i][j] = 'X';
//              } 
//         }
//     }
    
//     private void populateProtectedCells(int i, int j, char[][] board) {
//         board[i][j] = 'P';
//         for (int[] dir: dirs) {
//             int x = i + dir[0];
//             int y = j + dir[1];
//             if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
//             if (board[x][y] == 'O') {
//                  populateProtectedCells(x, y, board); 
//             }
//         }
//     }
// }