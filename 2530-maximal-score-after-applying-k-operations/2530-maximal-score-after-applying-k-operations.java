// O(NlogN + NlogN) O(N)
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for (int num: nums) maxHeap.add(num);
        long score = 0;
        while (k > 0) {
            int maxi = maxHeap.poll();
            score += maxi;
            double newElement = (double)maxi/3; 
            // System.out.println(newElement);
            maxHeap.add((int)Math.ceil(newElement));
            k--;
        } 
        return score;
    }
}