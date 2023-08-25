class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String s: wordList) set.add(s);
        
        int res = 0;
        Queue<String> q = new LinkedList<>(); 
        int level = 1;
        q.add(beginWord);
    
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();
                if (curr.equals(endWord)) return level;

                for (int i = 0; i < curr.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] a = curr.toCharArray();
                        a[i] = c;
                        String potential = String.valueOf(a);
                        if (set.contains(potential) && !visited.contains(potential)) {
                            q.add(potential);
                            visited.add(potential);
                        }
                    }
                }
            }
            level++;
        }
        
        return res;
    }
}