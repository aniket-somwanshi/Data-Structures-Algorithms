// O(N*M) O(M)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxiArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] histogramArray = new int[m];
        
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = matrix[i][j] == '1' ? 1 : 0; 
            }
        }
        
        for (int[] matrixRow: mat) {
            for (int j = 0; j < m; j++) {
                
                histogramArray[j] = matrixRow[j] == 1 ? histogramArray[j]+1 : 0;
                
            }
            maxiArea = Math.max(maxiArea, largestRectangleArea(histogramArray));
        }
        return maxiArea;
    }
    
    public int largestRectangleArea(int[] a) {
        int n = a.length;

        int[] left = getLeft(a, n);
        int[] right = getRight(a, n);
        
        
        int maxi = 0;
        
        for (int i = 0; i < n; i++) {
            int leftCandidate = (i - left[i]) * a[i];
            int rightCandidate = (right[i] - i) * a[i];
            int commonArea = a[i];
            int candidateTotalArea = leftCandidate + rightCandidate - commonArea;
            
            maxi = Math.max(maxi, candidateTotalArea);
        }
        
        return maxi;
    }
    
    private int[] getLeft(int[] a, int n) {
        int[] left = new int[n];
        Arrays.fill(left, -1);
        
        Stack<Pair> st = new Stack<>();
        
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] < st.peek().num) {
                int targetIndex = st.pop().index;
                left[targetIndex] = i;
            } 
            st.push(new Pair(a[i], i));
        }
        return left;
    }
    
    private int[] getRight(int[] a, int n) {
        int[] right = new int[n];
        Arrays.fill(right, n);
        
        Stack<Pair> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[i] < st.peek().num) {
                int targetIndex = st.pop().index;
                right[targetIndex] = i;
            } 
            st.push(new Pair(a[i], i));
        }
        return right;
    }
}

class Pair {
    int num;
    int index;
    public Pair(int n, int i) {
        num = n; 
        index = i;
    }
}