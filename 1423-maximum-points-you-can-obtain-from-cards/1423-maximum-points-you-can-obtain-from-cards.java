class Solution {
    public int maxScore(int[] a, int k) {
        int n = a.length;
        int left = 0;
        int leftDepth= left + k-1;
        int right = n-1;
        int rightDepth = right - k+1;
        
        int leftDepthSum = 0;
        for (int i = left; i <= leftDepth; i++) {
            leftDepthSum += a[i];
        }
        
        int rightDepthSum = 0;
        for (int i = rightDepth; i <= right; i++) {
            rightDepthSum += a[i];
        }
        
        System.out.println(leftDepthSum);
        System.out.println(rightDepthSum);

        int res = 0;
        while (left <= leftDepth || right >= rightDepth) {
            if (leftDepthSum >= rightDepthSum) {
                res += a[left];
                leftDepthSum -= a[left];
                left++;
                
                if (rightDepth >= n) continue; 
                rightDepthSum -= a[rightDepth];
                rightDepth++;
            }
            else {
                res += a[right];
                rightDepthSum -= a[right];
                right--;
                
                if (leftDepth < 0) continue;
                leftDepthSum -= a[leftDepth];
                leftDepth--;
            }
        }
        return res;
    }
}