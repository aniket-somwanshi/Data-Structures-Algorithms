// O(N*N) O(N) -- dp -- C=unknown constant
class Solution {
    public String countAndSay(int n) {
        String[] dp = new String[n+1];
        dp[1] = "1";
        
        for (int i = 2; i <= n; i++) {
            dp[i] = say(dp[i-1]);
        }
        return dp[n];
    }
    
    private String say(String input) {
        String res = "";
        int i = 0;
        while (i < input.length()) {
            // reset counts
            char currentNumber = input.charAt(i);
            int currentNumberCount = 0;
            // find cout of current character
            while (i < input.length() && input.charAt(i) == currentNumber) {
                currentNumberCount++;
                i++;
            }
            res += Integer.toString(currentNumberCount) + currentNumber;
        }
        return res;
    }
}


// // O(N*N) O(N) -- recursion -- C=unknown constant
// class Solution {
//     public String countAndSay(int n) {
//         if (n == 1) return "1";
//         return say(countAndSay(n-1));
//     }
    
//     private String say(String input) {
//         String res = "";
//         int i = 0;
//         while (i < input.length()) {
//             // reset counts
//             char currentNumber = input.charAt(i);
//             int currentNumberCount = 0;
//             // find cout of current character
//             while (i < input.length() && input.charAt(i) == currentNumber) {
//                 currentNumberCount++;
//                 i++;
//             }
//             res += Integer.toString(currentNumberCount) + currentNumber;
//         }
//         return res;
//     }
// }