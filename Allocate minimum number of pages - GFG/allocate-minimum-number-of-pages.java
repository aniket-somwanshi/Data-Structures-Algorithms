//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
public static int findPages(int[] a,int n,int m) {
    // precomputations 
    int sum = 0;
    for (int num: a) sum += num;
    int maxi = Integer.MIN_VALUE;
    for (int num: a) maxi = Math.max(maxi, num);
    
    // base cases
    if (m > n) return -1;
    
    if (m == 0) return sum;
    
    // binary search of "max pages to single guy allowed"
    int low = maxi;
    int high = sum;
    
    while (low <= high) {
        int mid = low + (high - low)/2;
        
        if (isPossible(a, n, mid, m)) {
            high = mid - 1;
        }
        else low = mid+1;
    }
    return low;
}

private static boolean isPossible(int[] a, int n, int maxAllowed, int m) {
    int studentsRequired = 1;
    int currentMax = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] > maxAllowed) return false; // base 
        
        if (currentMax + a[i] > maxAllowed) {
            studentsRequired++;
            currentMax = a[i];
        
            // exceeds 
            if (studentsRequired > m) return false;
        }
        else {
            currentMax += a[i];
        }
    }
    return studentsRequired <= m;
}
};