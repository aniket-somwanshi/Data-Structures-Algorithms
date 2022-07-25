class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int start = 0;
        int maxi = 0;
        int count_of_most_freq = 0;
        
        for (int end = 0; end < n; end++) {
            freq[s.charAt(end) - 'A']++;
            int current_char_freq = freq[s.charAt(end) - 'A'];
            count_of_most_freq = Math.max(count_of_most_freq, current_char_freq);
            
            while (((end - start) - count_of_most_freq + 1 ) > k ) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            
            maxi = Math.max(maxi, end - start + 1);
        }
        
        return maxi;
    }
    
        // wrong approach
//     int findMax(String s, int lifelines) {
//         char[] freq = new char[256];
//         for (int i = 0; i < 256; i++) freq[i] = 0;
//         int start = 0;
//         int k = lifelines;
//         char current = s.charAt(0);
//         int i = 0;
//         int maxi = 0;
//         while (i < s.length() && start < s.length()) {
//             // current is the same as this el
//             // so extend the length of valid max substring
//             if (s.charAt(i) == current) {
//                 freq[s.charAt(i)]++;
//                 i++;
//             }
//             // current is not equal to this element
//             // then use the lifeline
//             else if (k > 0) {
//                 k--;
//                 freq[s.charAt(i)]++;
//                 // extend length of valid max substring
//                 i++;
//             }
//             else {
//                 // lifelines are over
//                 // and we have a different element than current
//                 // so calculate length of valid max till now
//                 System.out.println(start+" "+i);
//                 maxi = Math.max(maxi, i - start);
//                 // if there are more same currents remove all of them
//                 // as they would not contribute to bigger substring
//                 while (start < s.length() && s.charAt(start) == current) {
//                     // decrease it's frequency
//                     freq[s.charAt(start)]--;
//                     start++;
//                 }
//                 // this is our new current
//                 if (start >= s.length()) break;
//                 current = s.charAt(start);
//                 // now we check in this window,
//                 // how many non-current elements are there
//                 int size_of_window = i - start;
//                 // restore value of k
//                 k = lifelines - (size_of_window - freq[current]);
//                 // if k exceeds lifelines, choose next current
//                 if (k > lifelines) {
//                     freq[current]--;
//                     start++;
//                     current = s.charAt(start);
//                 }
                
//             }
//         }
        
//         return Math.max(maxi, i - start);
//     }
    
//     public int characterReplacement(String s, int k) {
//         // find maxi 
//         int maxi = findMax(s, k);
//         // reverse 
//         StringBuilder s2 = new StringBuilder();
//         s2.append(s);
//         s2.reverse();
//         // find maxi
//         return Math.max(maxi, findMax(s2.toString(), k));
//     }
    
    
}