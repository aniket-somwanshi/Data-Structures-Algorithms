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
    memo = new Integer[n][m];
    return f(0,0);
} 

private int f(int i, int j) {
    // base cases 
    if (i == n && j == m) {
        // everything matched
        return 0;
    }
    if (i == n) {
       return m-j;
    }
    if (j == m) {
        return n-i;
    }
    
    if (memo[i][j] != null) return memo[i][j];
    
    // 3 cases
    // insertion 
    int candidate1 = f(i,j+1);
    candidate1 = candidate1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : candidate1 + 1; 
    
    // deletion
    int candidate2 = f(i+1, j);
    candidate2 = candidate2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : candidate2 + 1; 

    
    // move forward
    int candidate3 = s1[i] == s2[j] ? 0 + f(i+1,j+1) : Integer.MAX_VALUE;
    
    // answer is minimum of these 3 
    
    int res = Math.min(candidate1, Math.min(candidate2, candidate3));
    
    return memo[i][j]=res;
}

}