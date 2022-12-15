// O(N^2 + N^2) O(N^2)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // check if destination words exists in wordList
        boolean containsEndWord = false;
        for (String word: wordList) {
            if (word.equals(endWord)) {
                containsEndWord = true;
                break;
            }
        }
        
        if (!containsEndWord) return 0;
        
        // create adjacency list
        // include beginWord also
        String[] newWordList = new String[wordList.size()+1];
        newWordList[0] = beginWord;
        for (int i = 1; i < newWordList.length; i++) {
            newWordList[i] = wordList.get(i-1);
        }
        
        List<List<Integer>> adj = getAdjacencyList(newWordList);
        
        /// get shorstest path distance from source to destination
        // find destination index
        int destination = -1;
        for (int i = 0; i < newWordList.length; i++) 
            if (newWordList[i].equals(endWord)) 
                destination = i;
        
        return getShortestDistance(adj, 0, destination);
    }
    
    private int getShortestDistance(List<List<Integer>> adj, int src, int dest) {
        /// bfs
        int n = adj.size();
        
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(src);
        visited[src] = true;
        distance[src] = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int nb: adj.get(current)) {
                if (visited[nb]) continue;
                
                distance[nb] = distance[current] + 1;
                visited[nb] = true;
                
                q.add(nb);
            }
        }
        
        return distance[dest] == Integer.MAX_VALUE ? 0 : distance[dest]+1;
    }
    
    private List<List<Integer>> getAdjacencyList(String[] a) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < a.length; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (canTransform(a[i], a[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        return adj;
    }
    
    private boolean canTransform(String a, String b) {
        int differentCharacters = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) differentCharacters++;
        }
        return differentCharacters == 1;
    }
    
}
