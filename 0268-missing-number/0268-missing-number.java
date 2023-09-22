class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int exp = n*(n+1)/2;
        int act = 0;
        for (int num: nums) act += num;
        return (int)(exp-act);
    }
}