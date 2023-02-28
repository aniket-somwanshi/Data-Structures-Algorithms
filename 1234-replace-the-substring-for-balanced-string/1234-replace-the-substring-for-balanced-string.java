// wrong approach
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[] freq = new int[4];
        
        for (int i = 0; i < n; i++) {
            freq[ind(a[i])]++;
        }
        
        // if there are no excess elements return 0;
        if (freq[0] == n/4 && freq[1] == n/4 && freq[2] == n/4 && freq[3] == n/4) return 0;
        
        // excess freq
        for (int i = 0; i < 4; i++) {
            freq[i] = freq[i] - n/4 >= 0 ? freq[i] - n/4 : 0; 
        }        
        
        int start = 0;
        int end = 0;
        int minLength = n;
        while (end < n) {
            freq[ind(a[end])]--;
            // try to shrink
            while (isValidWindow(freq)) {
                minLength = Math.min(minLength, end - start + 1);
                freq[ind(a[start])]++;
                start++;
            }
            
            end++;
        }
        return minLength;
    }
    
    private boolean isValidWindow(int[] req) {
        for (int i = 0; i < 4; i++) if (req[i] > 0) return false;
        return true;
    }
    
    private int ind(char c) {
        if (c == 'Q') return 0;
        if (c == 'W') return 1;
        if (c == 'E') return 2;
        if (c == 'R') return 3;
        return 4;
    }
}

// // wrong approach
// class Solution {
//     public int balancedString(String s) {
//         int n = s.length();
//         char[] a = s.toCharArray();
//         int[] freq = new int[256];
        
//         Arrays.fill(freq, 0);
//         int start = 0;
//         while (start < n) {
//             freq[a[start]]++;
//             if (freq[a[start]] > n/4) {
//                 break;
//             }
//             start++;
//         }
        
//         Arrays.fill(freq, 0);
//         int end = 0;
//         while (end >= 0) {
//             freq[a[end]]++;
//             if (freq[a[end]] > n/4) {
//                 break;
//             }
//             end--;
//         }
        
//         // if there is no excess element, we're good so return 0
//         if (start == n && end == -1) return 0;
        
//         // case 1:
//         // single element window is there which is excess
//         // so just remove the excess number of characters
//         if (start > end) {
//             int actualLength =  start - end + 1;
//             int idealLength = n/4;
//             int excessLength = actualLength - idealLength;
//             return excessLength;
//         }
//         // case 2:
//         // the entire substring will need to be replaced
//         else {
//             return end - start + 1;
//         }
        
//     }
// }