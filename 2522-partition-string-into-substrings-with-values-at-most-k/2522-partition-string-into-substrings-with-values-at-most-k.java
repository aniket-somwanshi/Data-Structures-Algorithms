// O(N*N) O(N + N) greedy
// we should try to fit as much more numbers as possible in each parition!
class Solution {
    public int minimumPartition(String s, int k) {
        char[] a = s.toCharArray();
        int n = a.length;
        
        int totalPartitions = 0;
        long currentNumber = 0;
        int i = 0;
        while (i < n) {
            int startOfPartition = i;
            while (i < n && (currentNumber * 10) + Integer.parseInt(String.valueOf(a[i])) <= k) {
                currentNumber = (currentNumber * 10) + Integer.parseInt(String.valueOf(a[i]));
                i++;
            }
            if (i > startOfPartition)  {
                totalPartitions++;
                currentNumber = 0;
            }
            else return -1;
        }
        return totalPartitions;
    }
    
    
}

// // O(N*N) O(N + N) memo
// class Solution {
//     char[] a;
//     int n;
//     int k;
//     Integer[] memo;
//     public int minimumPartition(String s, int k) {
//         a = s.toCharArray();
//         n = a.length;
//         this.k = k;
//         memo = new Integer[n];
//         int res = f(0);
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
    
//     private int f(int ind) {
//         if (ind == n) return 0;
        
//         if (memo[ind] != null) return memo[ind];
        
//         int miniPartitions = Integer.MAX_VALUE;
//         long currentNumber = 0;
//         for (int i = ind; i < n; i++) {
//             currentNumber = (currentNumber * 10) + Integer.parseInt(String.valueOf(a[i]));
//             if (currentNumber <= k) {
//                 int res = f(i+1);
//                 if (res != Integer.MAX_VALUE) miniPartitions = Math.min(miniPartitions, 1 + res);
//             }
//             else break;
//         }
//         return memo[ind] = miniPartitions;
//     }
    
    
// }

// O((N^N)*N) O(N)
// class Solution {
//     char[] a;
//     int n;
//     int k;
//     public int minimumPartition(String s, int k) {
//         a = s.toCharArray();
//         n = a.length;
//         this.k = k;
//         int res = f(0);
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
    
//     private int f(int ind) {
//         if (ind == n) return 0;
        
//         int miniPartitions = Integer.MAX_VALUE;
//         int currentNumber = 0;
//         for (int i = ind; i < n; i++) {
//             currentNumber = (currentNumber * 10) + Integer.parseInt(String.valueOf(a[i]));
//             if (currentNumber <= k) {
//                 int res = f(i+1);
//                 if (res != Integer.MAX_VALUE) miniPartitions = Math.min(miniPartitions, 1 + res);
//             }
//             else break;
//         }
//         return miniPartitions;
//     }
    
    
// }