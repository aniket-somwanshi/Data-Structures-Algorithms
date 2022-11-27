//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// Since N*M is always odd we can never get a number that is not in the matrix and still half of the no's are greater than it and half of them is less than that number.

// O(log(10^9) * R*logC) O(1)
// O(32 * R * logC) O(1)
class Solution {
    int median(int a[][], int n, int m) {
    int mini = Integer.MAX_VALUE;
    int maxi = Integer.MIN_VALUE;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, a[i][j]);
            maxi = Math.max(maxi, a[i][j]);
        }
    }
    
    int medianTarget = n*m/2;
    
    int low = mini;
    int high = maxi;
    while (low <= high) {
        int mid = low + (high - low)/2;
        
        int numbersLessThanOrEqualToMid = 0;
        for (int[] row: a) {
            numbersLessThanOrEqualToMid += bs(row, mid);    
        }
        
        if (numbersLessThanOrEqualToMid <= medianTarget) {
            low = mid+1;
        } 
        else {
            high = mid-1;
        }
    }
    return low;
}

// returns no of elements <= num in the array
private int bs(int[] a, int num) {
    int low = 0;
    int high = a.length-1;
    while (low <= high) {
        int mid = low + (high - low)/2;
        if (a[mid] <= num) {
            low = mid+1;
        }
        else {
            high = mid-1;
        }
    }
    return low;
}
}