class Pair <T, U> {
    T first;
    U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] arrayRankTransform(int[] a) {
        int n = a.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a1, a2) -> a1.first - a2.first
        ); 
        
        for (int i = 0; i < n; i++) pq.add(new Pair(a[i], i));
        
        int rank = 1;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            int index = current.second;
            int el = current.first;
            
            a[index] = rank;
            if (!pq.isEmpty() && pq.peek().first > el) rank++; 
        }
        return a;
    }
}