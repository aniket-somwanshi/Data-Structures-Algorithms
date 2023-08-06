class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int[] prevSmaller = getPrevSmaller(heights);
        int[] nextSmaller = getNextSmaller(heights);
        
        int maxi = 0;
        
        for (int i = 0; i < n; i++) {
            int prevSmallerIndex = prevSmaller[i];
            int nextSmallerIndex = nextSmaller[i];
            
            int length = nextSmallerIndex - prevSmallerIndex - 1;
            int height = heights[i];
            
            int area = length * height;
        
            maxi = Math.max(maxi, area);
        }
        
        return maxi;
    }
    
    private int[] getPrevSmaller(int[] a) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }    
            if (st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    
    private int[] getNextSmaller(int[] a) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int[] res = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }    
            if (st.isEmpty()) res[i] = n;
            else res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
}