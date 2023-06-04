// O(2(V+E) + N) O(4N) 
// topo sort for grps and  
// topo sort for items in grp
class Solution {
    List<List<Integer>> adj;
    int n;
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int v = i;
            for (int u: beforeItems.get(i)) {
                adj.get(u).add(v);
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && dfs(i, stack, visited)) return new int[] {};
        }
        
        
        
        
        // create real groups array
        // so that each node that's not part of any group is
        // in a new separate group as opposed to being in 
        // a 'no group' group
        
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m; 
                m++;
            }
        }
        
        List<List<Integer>> groupedItems = new ArrayList<>();
        for (int i = 0; i < m; i++) groupedItems.add(new ArrayList<>());
        
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            int currentItem = stack.pop();
            int currentGroup = group[currentItem];
            if (currentGroup == -1) currentGroup = m;
            
            groupedItems.get(currentGroup).add(currentItem);
        }
        
        // create topological sort for groups
        List<List<Integer>> grpAdj = new ArrayList<>();
        for (int i = 0; i < m; i++) grpAdj.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            int v = i;
            for (int u: beforeItems.get(i)) {
                int uGrp = group[u];
                int vGrp = group[v];
                // avoid self edges
                if (uGrp != vGrp) grpAdj.get(uGrp).add(vGrp);
            }
        }
        
        // topo sort on groups
        Stack<Integer> grpStack = new Stack();
        visited = new int[m];
        Arrays.fill(visited,0);
        
        for (int i = 0; i < m; i++) {
            if (visited[i] == 0 && grpDfs(i, grpAdj, grpStack, visited)) return new int[] {};
        }
        
        int[] res= new int[n];
        int resIdx = 0;
        
        // traverse groups in order
        while (!grpStack.isEmpty()) {
            int currentGrp = grpStack.pop();
            // print the grp nodes in order
            for (int item: groupedItems.get(currentGrp)) {
                res[resIdx++] = item;
            }
        }
        
        
        return res;
    }
    
    private boolean grpDfs(int node, List<List<Integer>> grpAdj, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;
        for (int v: grpAdj.get(node)) {
            if (visited[v] == 1) return true;
            else if (visited[v] == 0 && grpDfs(v, grpAdj, stack, visited)) return true;
        }
        visited[node] = 2;
        stack.push(node);
        return false;
    }
    
    private boolean dfs(int node, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;
        for (int v: adj.get(node)) {
            if (visited[v] == 1) return true;
            else if (visited[v] == 0 && dfs(v, stack, visited)) return true;
        }
        visited[node] = 2;
        stack.push(node);
        return false;
    }
}