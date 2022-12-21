//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int M,int N)
{
    int n = M;
    int m = N;
    char[] s1 = X.toCharArray();
    char[] s2 = Y.toCharArray();
    int[][] dp = new int[n+1][m+1];
    
    // base cases
    for (int i = 0; i < n+1; i++) dp[i][m] = 0;
    for (int j = 0; j < m+1; j++) dp[n][j] = 0;
    
    for (int i = n-1; i >= 0; i--) {
        for (int j = m-1; j >= 0; j--) {
            int res = 0;
            res = Math.max(res, dp[i+1][j]);
            res = Math.max(res, dp[i][j+1]);
            if (s1[i] == s2[j]) res = Math.max(res, dp[i+1][j+1] + 1);
            
            dp[i][j] = res;
        }
    }
    
    // LCS length
    int lcsLength = dp[0][0];
    
    return n+m-lcsLength;
}
}