class Solution {
    private Set<Integer> bad;
    public int maxLength(List<String> arr) {
        String[] a = arr.toArray(new String[0]);
        int n = a.length;
        
        // there can be some inherently bad strings 
        // strings that have repeating characters in themselves
        // so never consider those lot
        bad = new HashSet<>();
        for (int ind = 0; ind < n; ind++) {
            boolean[] vis = new boolean[26];
            for (int i = 0; i < a[ind].length(); i++) {
                if (vis[a[ind].charAt(i)-'a']) {
                    bad.add(ind);
                }
                vis[a[ind].charAt(i)-'a'] = true;
            }
        }
        
        boolean[] visited = new boolean[26];
        return f(0, visited, a);
    }
    
    private int f(int i, boolean[] visited, String[] a) {
        // base
        if (i == a.length) return 0;
        
        int maxiLen = 0;
        if (!bad.contains(i) && isValid(a[i], visited)) {
            // update state
            addToFreq(a[i], visited);
            
            // get answer
            maxiLen = Math.max(maxiLen, a[i].length() + f(i+1, visited, a));
            
            // backtrack state
            removeFromFreq(a[i], visited);   
        }
        
        // skip this string 
        maxiLen = Math.max(maxiLen, 0 + f(i+1, visited, a));
        
        return maxiLen;
    }
    
    private void removeFromFreq(String s, boolean[] visited) {
        for (char c: s.toCharArray()) visited[c-'a'] = false;
    }
    
    private void addToFreq(String s, boolean[] visited) {
        for (char c: s.toCharArray()) visited[c-'a'] = true;
    }
    
    private boolean isValid(String s, boolean[] visited) {
        for (char c: s.toCharArray()) if (visited[c-'a']) return false;
        return true;
    }
}