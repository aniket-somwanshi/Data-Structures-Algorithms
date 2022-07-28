class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int p=pq.poll();
            int q=pq.poll();
            if(p==q){
                continue;
            }
            else{
                q=p-q;
                pq.add(q);
            }
        }
        if(pq.size()==0){
            return 0;
        }
        
      return pq.poll();
          
    }
}