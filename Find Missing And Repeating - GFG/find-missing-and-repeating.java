//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// O(4N) O(1) -- XOR 
// 1. X = XOR of all elements
// 2. Y = XOR of all elements from 1 to n
// 3. X ^ Y will have the XOR of the missing and the extra number
// 4. Only task is to find X and Y 
// 5. We can separate X candidates and Y candidates into 2 buckets
// based on the differentiating bit in X^Y
// 6. Iterate over a[i] and based on differentiaing bit
// separate them into bucket A or bucket B
// 7. Iterate over 1 to n, and based on differentiating bit
// separate them into bucket A or bucket B
// so now, if extra number was in A, there would be 3 of those extra numbers 
// in bucket A, cos in a[i] there are 2 and in 1 to n there is one
// On the other hand, since, the missing number is in bucket B,
// bucket B will single appearance of missing number, as there is none in a[i]
// and there is one in 1 to n. 
// So if we XOR inside bucket A, the 3s will become one, and other duplicates will cancel out
// if we XOR inside bucket B, the single number will remain and other duplicates will cancel out
// finally we have 2 numbers X and Y, one is the missing no. other one is extra number
// iterate the og array to find which one is which, and return2
class Solve {
    int[] findTwoElement(int a[], int n) {
        int allXor = a[0];
        
        int i = 1;
        
        int x = 0;
        int y = 0;
        
        for (i = 1; i < n; i++) {
            allXor = allXor ^ a[i];
        }
        
        // xor with 1 to n numbers
        for (i = 1; i <= n; i++) {
            allXor = allXor ^ i;
        }
        
        // get the rightmost set bit in number in x^y
        int setBitNumber = allXor & ~(allXor - 1);
        
        // separate x and y from x^y aka allXor
        
        for (i = 0; i < n; i++) {
            if ((a[i] & setBitNumber) != 0) {
                // go to bucket 1
                x = x ^ a[i];
            }
            else {
                // go to bucket 2
                y = y ^ a[i];
            }
        }
        
        for (i = 1; i <= n; i++) {
            if ((i & setBitNumber) != 0) {
                x = x ^ i;
            }
            else {
                y = y ^ i;
            }
        }
        
        
        // check if x and y are missing or extra number respectively
        boolean isXPresent = false;
        boolean isYPresent = false;
        
        for (i = 0; i < n; i++) {
            if (a[i] == x) {
                isXPresent = true; break;
            }
            if (a[i] == y) {
                isYPresent = true; break;
            }
        }
        
        int missing = -1;
        int extra = -1;
        if (isXPresent == false) {
            missing = x;
            extra = y;
        }
        else {
            missing = y;
            extra = x;
        }
        return new int[] {extra, missing};
    }
}
// class Solve {
//     int[] findTwoElement(int a[], int n) {
//         int extra = -1;
//         int i = 0;
//         while (i < n) {
//             int correctPosition = a[i]-1;
//             // if we are not at the correct position,
//             if (i != correctPosition) {
//                 // if there is already a correct guy 
//                 // at the correct position,
//                 // this guy is an extra guy
//                 if (a[correctPosition] == a[i]) {
//                     extra = a[i];
//                     i++;
//                 }
//                 else {
//                     // place it at the correct position
//                     int t = a[i];
//                     a[i] = a[correctPosition];
//                     a[correctPosition] = t;
//                 }
//             }
//             else i++;
//         }
        
//         // finally the index that doesnt' have the 
//         // correct guy, we found the missing guy
//         int missing = -1;
//         for (int j = 0;  j< n; j++) {
//             if (j != a[j]-1) missing = j+1;
//         }
//         return new int[] {extra, missing};
//     }
// }