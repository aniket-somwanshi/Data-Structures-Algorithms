//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    char[] s1;
    char[] s2;
    int n;
    int m;
    Integer[][] memo;
public int minOperations(String str1, String str2) 
{ 
    s1 = str1.toCharArray();
    s2 = str2.toCharArray();
    n = s1.length;
    m = s2.length;
    int[][] dp = new int[n+1][m+1];
    
    // base case 
    for (int i = 0; i <= n; i++) {
        dp[i][m] = n-i;
    }
    for (int j = 0; j <= m; j++) {
        dp[n][j] = m-j;
    }
    dp[n][m]=0;
    
    
    for (int i = n-1; i >= 0; i--) {
        for (int j = m-1; j >= 0; j--) {
            // 3 cases
            // insertion 
            int candidate1 = dp[i][j+1];
            candidate1 = candidate1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : candidate1 + 1; 
            
            // deletion
            int candidate2 = dp[i+1][j];
            candidate2 = candidate2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : candidate2 + 1; 
        
            
            // move forward
            int candidate3 = s1[i] == s2[j] ? 0 + dp[i+1][j+1] : Integer.MAX_VALUE;
            
            // answer is minimum of these 3 
            
            int res = Math.min(candidate1, Math.min(candidate2, candidate3));
            
            dp[i][j] = res;
        }
    }
    
    return dp[0][0];
} 

}