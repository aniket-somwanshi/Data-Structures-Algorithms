// O(N*N*2) O(N*N*2 + N)
class Solution {
    int[] nums;
    int n;
    Integer[][][] cache;
    public boolean PredictTheWinner(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.cache = new Integer[n][n][2];
        return f(0, n-1, true) >= 0;
    }
    
    private int f(int start, int end, boolean isPlayer1sTurn) {
        if (start > end) {
            return 0;
        }
        
        if (cache[start][end][isPlayer1sTurn ? 0 : 1] != null) {
            return cache[start][end][isPlayer1sTurn ? 0 : 1];
        } 
        
        int res = 0;
        
        if (isPlayer1sTurn) {
            res = Math.max(nums[start] + f(start+1, end, false),
                          nums[end] + f(start, end-1, false));
        }
        else {
            res = Math.min(-nums[start] + f(start+1, end, true),
                          -nums[end] + f(start, end-1, true));
        }
        
        return cache[start][end][isPlayer1sTurn ? 0 : 1] = res;
    }
}


// // O(2^N) O(N)
// class Solution {
//     int[] nums;
//     int n;
//     public boolean PredictTheWinner(int[] nums) {
//         this.nums = nums;
//         this.n = nums.length;
        
//         return f(0, n-1, true) >= 0;
//     }
    
//     private int f(int start, int end, boolean isPlayer1sTurn) {
//         if (start > end) {
//             return 0;
//         }
        
//         int res = 0;
        
//         if (isPlayer1sTurn) {
//             res = Math.max(nums[start] + f(start+1, end, false),
//                           nums[end] + f(start, end-1, false));
//         }
//         else {
//             res = Math.min(-nums[start] + f(start+1, end, true),
//                           -nums[end] + f(start, end-1, true));
//         }
        
//         return res;
//     }
// }