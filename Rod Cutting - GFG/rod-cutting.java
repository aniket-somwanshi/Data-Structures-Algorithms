//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[] prev = new int[n+1];
        int[] current = new int[n+1];
        
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0) current[j] = 0;
                else if (i <= j) {
                    current[j] = Math.max(prev[j], price[i-1] + current[j-i]);
                }
                else {
                    current[j] = prev[j];
                }
            }
            prev = current;
        }
        return prev[n];
    }
}