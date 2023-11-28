class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int noOfOnes = 0;
        int noOfZeros = 0;
        int totalOnes = 0;
        int totalZeros = 0;
        int maxi = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            totalZeros += c == '0' ? 1 : 0;
            totalOnes += c == '1' ? 1 : 0;
        }
        
        for (int i = 0; i < n-1; i++) {
            char c = s.charAt(i);
            noOfZeros += c == '0' ? 1 : 0;
            noOfOnes += c == '1' ? 1 : 0;
            
            int onesOnRight = totalOnes - noOfOnes;
            
            // System.out.println(totalZeros + "-" + onesOnRight);
            
            maxi = Math.max(maxi, noOfZeros + onesOnRight);
        }
        
        return maxi;
    }
}