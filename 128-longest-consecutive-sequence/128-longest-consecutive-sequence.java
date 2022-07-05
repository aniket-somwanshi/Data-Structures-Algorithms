class Solution {
    /*
    O(N) O(N)
    Insert every element in hashmap
    take one element 
    try to decrease it as long as that element is also present in map
    then try looking for forward consecutive elements
    try to incrase it as long as that element is also present in map
    also remove those elements from map as we count them
    count the stretch of forward and backwards consecutive numbers found
    return longest 
    */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0; 
        if (nums.length == 1) return 1;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int maxi = 1;
        for (int num: nums) {
            int chain = 1;
            if (set.contains(num)) {
                // go backwards as much as we can
                int back = num-1;
                while (set.contains(back)) {
                    chain++;
                    set.remove(back);
                    back--;
                }
                // go forwards as much as we can
                int forward = num+1;
                while (set.contains(forward)) {
                    chain++;
                    set.remove(forward);
                    forward++;
                }
            }
            set.remove(num);
            maxi = Math.max(maxi, chain);
        }
        return maxi;
    }
}