class Solution {
    public String freqAlphabets(String str) {
        int n=str.length();
              String ans="";
        for(int i=0;i<n;i++)
        {
            if(i+2<n && str.charAt(i+2)=='#')
            {
                String a=str.substring(i,i+2);
                ans+=(char)('a'+Integer.valueOf(a)-1);
                i+=2;
            }
            else
            {
             ans+=(char)('a'+Integer.valueOf(str.charAt(i)-'0')-1);
            }
        }
        return ans;
    }
}