class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result ="";
        
        for(int i=0,j=0;i<word1.length()||j<word2.length();i++,j++){
            if(i<word1.length()){
                result+=word1.charAt(i);
            }
            if(j<word2.length()){
                result+=word2.charAt(j);
            }
        }
        return result;
    }
}