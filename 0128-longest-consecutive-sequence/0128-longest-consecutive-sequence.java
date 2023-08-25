class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        
        int maxiConsecutive = 0;
        
        for (int num: nums) {
            if (!set.contains(num)) continue;
            
            set.remove(num);
            
            // go back as much as u can
            int prev = 0;
            int prevNumber = num-1;
            while (set.contains(prevNumber)) {
                prev++;
                set.remove(prevNumber);
                prevNumber--;
            }
            
            // go forward as much as u can
            int next = 0;
            int nextNumber = num+1;
            while (set.contains(nextNumber)) {
                next++;
                set.remove(nextNumber);
                nextNumber++;
            }
            
            // count total chain length
            int chainLength = 1 + prev + next;
            maxiConsecutive = Math.max(maxiConsecutive, chainLength);
        }
        
        return maxiConsecutive;
    }
}