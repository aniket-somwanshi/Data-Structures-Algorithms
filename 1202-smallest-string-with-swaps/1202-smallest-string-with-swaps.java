// O(V+E + NlogN) O(N+E + 3N)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] a = s.toCharArray();
        
        // create a graph
        List<List<Integer>> adj = getAdjacencyList(pairs, n);
        
        // traverse component wise
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                PriorityQueue<Character> chars = new PriorityQueue<>();
                PriorityQueue<Integer> indices = new PriorityQueue<>();
                dfs(i, adj, visited, chars, indices, a);
                // put smallest chars of that component, 
                // at smallest indices in the component
                dispatchSmallestCharacters(chars, indices, a);
            }
        }
        
        return String.valueOf(a);
    }
    
    private void dispatchSmallestCharacters(PriorityQueue<Character> chars, PriorityQueue<Integer> indices, char[] a) {
        while (!indices.isEmpty()) {
            int smallestIndex = indices.poll();
            char smallestChar = chars.poll();
            a[smallestIndex] = (char)smallestChar; 
        }
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, PriorityQueue<Character> chars, PriorityQueue<Integer> indices, char[] a) {
        visited[node] = true;
        
        // add to component
        indices.add(node);
        chars.add(a[node]);
        
        for (int v: adj.get(node)) {
            if (!visited[v]) {
                dfs(v, adj, visited, chars, indices, a);
            }
        }
    }
    
    private List<List<Integer>> getAdjacencyList(List<List<Integer>> pairs, int n) {
        // initialize list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> pair: pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
}