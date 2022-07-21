class DSU {
    private int[] rank;
    private int[] parent;
    private int MAX_ELEMENTS = 100000;
    public DSU() {
        this.rank = new int[MAX_ELEMENTS];
        this.parent = new int[MAX_ELEMENTS];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
    }
    
    public int getParent(int node) {
        if (parent[node] == node) return node;
        else return parent[node] = getParent(parent[node]);
    }
    
    public void union(int node1, int node2) {
        int parent1 = getParent(node1);
        int parent2 = getParent(node2);
        
        if (parent1 == parent2) return;
        
        if (rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        }
        else if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        }
        else {
            parent[parent2] = parent1;
            rank[parent1]++;
        }
    }
    
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(); 
        
        for (String equation: equations) {
            if (equation.charAt(1) == '=') {
                dsu.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        
        for (String equation: equations) {
            if (equation.charAt(1) == '!') {
                int node1 = equation.charAt(0) - 'a';
                int node2 = equation.charAt(3) - 'a';
                
                if (dsu.getParent(node1) == dsu.getParent(node2)) return false;
            }
        }
        
        return true;
    }
}








