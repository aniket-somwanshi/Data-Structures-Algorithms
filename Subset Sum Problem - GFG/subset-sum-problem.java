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

    // O(N*SUM) O(SUM)
    static Boolean isSubsetSum(int n, int a[], int sum){
        int cols = sum+1;
        int rows = n;
        boolean[] up = new boolean[cols];
        
        // fill first row
        if (a[0] < rows) up[a[0]] = true; // rest are already zero
        
        // fill rest
        for (int i = 1; i < rows; i++) {
            boolean[] current = new boolean[cols]; 
            for (int j = 0; j < cols; j++) {
                if (j == 0) current[j] = true;
                else if (a[i] > j) current[j] = up[j];
                else current[j] = up[j] || up[j-a[i]];
            }
            up = current;
        }
        return up[cols-1];
    }
}