class Solution {
    public String largestNumber(int[] a) {
        int n = a.length;
        // convert all numbers to strings
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = String.valueOf(a[i]);
        }
        Arrays.sort(s, (x,y)->cmp(x,y));
        String res= String.join("", s);
        // remove leading zeroes
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') i++;
        if (i == res.length()) return "0";
        return res.substring(i);
    }
    
    // returns non-positive value if n1 should come before n2
    // returns non-positive value if n1 > n2
    private int cmp(String n1, String n2) {
        int i = 0;
        int total = n1.length() + n2.length();
        int s1 = n1.length();
        int s2 = n2.length();
        
        while (i < total) {
            if (n1.charAt(i%s1) > n2.charAt(i%s2)) {
                return -1;
            }
            else if (n2.charAt(i%s2) > n1.charAt(i%s1)) {
                return 1;
            }
            i++;
        }
        return 0;
    }
}

// class Solution {
//     public String largestNumber(int[] a) {
//         int n = a.length;
//         // convert all numbers to strings
//         String[] s = new String[n];
//         for (int i = 0; i < n; i++) {
//             s[i] = String.valueOf(a[i]);
//         }
//         Arrays.sort(s, (x,y)->cmp(x,y));
//         String res= String.join("", s);
//         // remove leading zeroes
//         int i = 0;
//         while (i < res.length() && res.charAt(i) == '0') i++;
//         if (i == res.length()) return "0";
//         return res.substring(i);
//     }
    
//     // returns non-positive value if n1 should come before n2
//     // returns non-positive value if n1 > n2
//     private int cmp(String n1, String n2) {
//         String n12 = n1+n2;
//         String n21 = n2+n1;
//         for (int i = 0; i < n1.length()+n2.length(); i++) {
//             if (n12.charAt(i) > n21.charAt(i)) return -1;
//             else if (n21.charAt(i) > n12.charAt(i)) return 1;
//         }
//         return 0;
// //         int i = 0;
// //         int j = 0;
// //         int miniSize = Math.min(n1.length(), n2.length());
        
// //         while (i < miniSize && j < miniSize) {
// //             if (n1.charAt(i) > n2.charAt(j)) {
// //                 return -1;
// //             }
// //             else if (n2.charAt(j) > n1.charAt(i)) {
// //                 return 1;
// //             }
// //             i++;
// //             j++;
// //         }
        
// //         // here, one of the number is finished
// //         if (i < n1.length()) { // n2 has finished
// //             // n1 is greater than n2 only if the current digit of n1 
// //             // is greater than the previous common digit 
// //             if (n1.charAt(i) > n1.charAt(i-1)) return -1;
// //             else return 1;
// //         }
// //         else if (j < n2.length()) {
// //             if (n2.charAt(j) > n2.charAt(j-1)) return 1;
// //             else return -1;
// //         }
        
// //         return 0;
//     }
// }