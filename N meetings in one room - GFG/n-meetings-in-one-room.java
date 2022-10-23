//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting {
    int start;
    int end;
    public Meeting(int x, int y) {
        start = x;
        end = y;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        Meeting[] a = new Meeting[n];
        for (int i = 0; i < n; i++) a[i] = new Meeting(start[i], end[i]); 
        Arrays.sort(a, (a1, a2) -> a1.end - a2.end);
        
        int count = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (Meeting m: a) {
            if (m.start > prevEnd) {
                count++;
                prevEnd = m.end;
            }
        }
        
        return count;
    }
}
