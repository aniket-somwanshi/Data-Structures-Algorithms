//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    


public long kthElement(int a1[], int a2[], int n, int m, int k) {
    int low = m > k ? 0 : k - m;
    int high = Math.min(k, n);
    
    while (low <= high) {
        int mid = low + (high - low)/2;
        
        int cut1 = mid;
        int cut2 = k - cut1;
        
        int l1 = cut1-1 >= 0 ? a1[cut1-1] : Integer.MIN_VALUE; 
        int l2 = cut2-1 >= 0 ? a2[cut2-1] : Integer.MIN_VALUE; 
        
        int r1 = cut1 < n ? a1[cut1] : Integer.MAX_VALUE; 
        int r2 = cut2 < m ? a2[cut2] : Integer.MAX_VALUE;
        
        // left a1 too heavy
        if (l1 > r2) {
            // reduce elements from a1, ie reduce cut1 ie mid
            high = mid - 1;
        }
        else if (l2 > r1) {
            low = mid + 1;
        }
        else {
            // valid
            return Math.max(l1, l2);
        }
    }
    return 0;
}

}