class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int exp = 0;
        for (int i = 0; i <= n; i++) exp ^= i;
        
        int act = 0;
        for (int num: nums) act ^= num;
        
        return exp ^ act;
    }
}
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         long exp = n*(n+1)/2;
//         long act = 0;
//         for (int num: nums) act += num;
//         return (int)(exp-act);
//     }
// }