class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            String currentWord = words[i];
            
            int currentResult = 0;
            if (isVowel(currentWord.charAt(0)) && 
                isVowel(currentWord.charAt(currentWord.length()-1))) {
                currentResult = 1;
            }
            
            prefixSum[i] = currentResult + (i - 1 >= 0 ? prefixSum[i-1] : 0);
        }
        
        int[] res = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            int total = prefixSum[right];
            int extra = left - 1 >= 0 ? prefixSum[left - 1] : 0;
            
            res[i] = total - extra;
        }
        
        return res;
    }
    
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}