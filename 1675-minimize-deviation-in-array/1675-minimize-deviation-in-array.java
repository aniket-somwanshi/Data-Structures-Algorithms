class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        int min = Integer.MAX_VALUE;

        for(int i : nums){
            
            if(i % 2 == 1) i *= 2; //if no. is odd converting it in even
            
            min = Math.min(min, i); //calculating the min value

            pq.add(i);   //! all elements are added in pq
        }

        int diff = Integer.MAX_VALUE;
        
        while(pq.peek() %2 == 0)  // run the loop untill the top of pq. is even
        {
            int max = pq.remove();
            diff = Math.min(diff, max-min);
            
            min = Math.min(min, max/2);   // one of the edge cases to look out for!
            
            pq.add(max/2);
        }

        return Math.min(diff, pq.peek()-min);
    }
}