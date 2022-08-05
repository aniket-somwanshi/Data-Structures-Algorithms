class Solution {
       String reverse(String s)
    {
        String ans="";
        for(int i=1;i>=0;i--)
            ans+=s.charAt(i);
        
        return ans;
    }

    public int longestPalindrome(String[] words) {
        int count=0;
        HashMap<String, Integer> map=new HashMap<>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(Map.Entry m: map.entrySet()){
            String key=(String)m.getKey();
            int val=(int)m.getValue();
            String rev=reverse(key);
            if(map.containsKey(rev)){
                if(rev.equals(key)){
                    int y=map.get(rev);
                    if(y%2!=0){
                        y--;
                    }
                    count+=(2*y);
                    map.put(key,map.get(key)-y);
                }else{
                    int min=Math.min(val,map.get(rev));
                    count+=(4*min);
                    map.put(key,val-min);
                    map.put(rev,map.get(rev)-min);
                }
            }
        }
         for(Map.Entry m: map.entrySet())
        {
            String key=(String)m.getKey();
            int val=(int)m.getValue();
            if(key.charAt(0)==key.charAt(1) && val>0)
            {
                count+=2;
                break;
            }
        }
        return count;
    }
        
    
}