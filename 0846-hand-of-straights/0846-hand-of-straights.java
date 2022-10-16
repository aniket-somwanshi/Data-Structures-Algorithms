class Solution {
    // O(NlogN + NlogN) O(N)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int card: hand) minHeap.add(card);
        
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            List<Integer> unwanted = new LinkedList<>();
            
            int elementsTaken = 0;
            while (!minHeap.isEmpty() && elementsTaken < groupSize - 1) {
                if (minHeap.peek() == current + 1) {
                    elementsTaken++;
                    current = minHeap.poll();
                }
                else if (minHeap.peek() == current) {
                    unwanted.add(minHeap.poll());
                }
                else {
                    return false;
                }
            }
            if (elementsTaken < groupSize - 1) return false;
            // put the unwanted list back into minHeap
            // they might be useful later
            for (int u: unwanted) minHeap.add(u);
        }
        return true;
    }
}