class Solution {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int vote = 0;
        for (int num: nums) {
            if (vote == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                vote++;
            }
            else vote--;

        }
        return candidate;
    }
}