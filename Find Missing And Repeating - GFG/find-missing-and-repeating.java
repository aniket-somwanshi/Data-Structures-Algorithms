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

class Solve {
    int[] findTwoElement(int a[], int n) {
        int extra = -1;
        int i = 0;
        while (i < n) {
            int correctPosition = a[i]-1;
            // if we are not at the correct position,
            if (i != correctPosition) {
                // if there is already a correct guy 
                // at the correct position,
                // this guy is an extra guy
                if (a[correctPosition] == a[i]) {
                    extra = a[i];
                    i++;
                }
                else {
                    // place it at the correct position
                    int t = a[i];
                    a[i] = a[correctPosition];
                    a[correctPosition] = t;
                }
            }
            else i++;
        }
        
        // finally the index that doesnt' have the 
        // correct guy, we found the missing guy
        int missing = -1;
        for (int j = 0;  j< n; j++) {
            if (j != a[j]-1) missing = j+1;
        }
        return new int[] {extra, missing};
    }
}