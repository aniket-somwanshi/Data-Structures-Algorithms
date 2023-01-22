class Solution {
    // O(N*2^N, O(N*N))
    // Backtracking + dp 
    // find if the string is palindrome, in O(1) time, 
    // by storing in dp array
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s == "") return res;
        int n = s.length();
        List<String> current = new LinkedList<>();
        boolean[][] dp = new boolean[n][n];
        int index = 0;
        partitionUtil(index, s.length(), s, current, res, dp);
        return res;
    }
    
    private void partitionUtil(int index, int n, String s, List<String> current, List<List<String>> res, boolean[][] dp) {
        if (index == n) {
            res.add(new ArrayList<String>(current));
            return;
        }
        for (int i = index; i < n; i++) {
            if (s.charAt(index) == s.charAt(i) && (i - index <= 2 || dp[index+1][i-1])) {
                dp[index][i] = true;
                current.add(s.substring(index, i+1));
                partitionUtil(i + 1, n, s, current, res, dp);
                current.remove(current.size()-1); // backtrack
            }
        }
    }
    
    
    // O(N*2^N) O(N) Backtracking
//     public List<List<String>> partition(String s) {
//         List<List<String>> res = new LinkedList<>();
//         if (s == "") return res;
        
//         List<String> current = new LinkedList<>();
//         int index = 0;
//         partitionUtil(index, s.length(), s, current, res);
//         return res;
//     }
    
//     private void partitionUtil(int index, int n, String s, List<String> current, List<List<String>> res) {
//         if (index == n) {
//             res.add(new ArrayList<String>(current));
//             return;
//         }
//         for (int i = index; i < n; i++) {
//             if (isPalindrome(index, i, s)) {
//                 current.add(s.substring(index, i+1));
//                 partitionUtil(i + 1, n, s, current, res);
//                 current.remove(current.size()-1); // backtrack
//             }
//         }
//     }
    
//     private boolean isPalindrome(int start, int end, String s) {
//         while (start < end) {
//             if (s.charAt(start) != s.charAt(end)) return false;
//             start++;
//             end--;
//         }
//         return true;
//     }
}