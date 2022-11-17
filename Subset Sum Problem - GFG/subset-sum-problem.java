//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int a[], int sum){
        int cols = sum+1;
        int rows = n;
        boolean[][] dp = new boolean[rows][cols];
        
        // fill first row
        if (a[0] < rows) dp[0][a[0]] = true; // rest are already zero
        
        // fill first column
        for (int i = 0; i < rows; i++) {
            dp[i][0] = true;
        }
        
        // fill rest
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (a[i] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] || dp[i-1][j-a[i]];
            }
        }
        return dp[rows-1][cols-1];
    }
}