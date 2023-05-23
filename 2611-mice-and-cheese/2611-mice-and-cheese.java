class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->((reward1[b]-reward2[b]) - (reward1[a]-reward2[a]))); // index
        for (int i = 0; i < n; i++) {
            pq.add(i);    
        }
        int res = 0;
        // remove top k and gain out reward1 for them
        for (int i = 0; i < k; i++) {
            int index = pq.poll();
            int gain = reward1[index];
            res += gain;
        }
                                                                
        for (int i = 0; i < (n-k); i++) {
            int index = pq.poll();
            int gain = reward2[index];
            res += gain;
        }
                                                                
                                                                
             return res;                                                   
                                                                
                                                                
    }
}