//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] a,int k) {
        int n = a.length;
    int[] current = new int[k];
    Arrays.fill(current, 0);
    
    ArrayList<Integer> res = new ArrayList<Integer>();
    while (res.size() < k*k) {
        // find the min element among all arrays
        int miniIndex = -1;
        int mini = Integer.MAX_VALUE;
        int miniArrayIndex = -1;
        for (int i = 0; i < n; i++) {
            if (current[i] < n && a[i][current[i]] < mini) {
                mini = a[i][current[i]];
                miniIndex = current[i];
                miniArrayIndex = i;
            }
        }
        // we have our next element 
        res.add(mini);
        current[miniArrayIndex]++;
    }
    return res;
}
}