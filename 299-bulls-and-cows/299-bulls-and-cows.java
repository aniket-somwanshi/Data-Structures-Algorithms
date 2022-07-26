class Solution {
    public String getHint(String s, String g) {
        String res ="";
        int cow=0,bull=0;
        HashMap<Character,Integer> map = new  HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            char ch= g.charAt(i);
            if(c==ch){
                bull++;
            }
            else{
                map.put(c,map.getOrDefault(c,0)+1);
            }
            
        }
        for(int i=0;i<g.length();i++){
                   char ch = s.charAt(i);
            char c= g.charAt(i);
            if(c!=ch && map.getOrDefault(c,0)>0){
                cow++;
                map.put(c,map.get(c)-1);
            }
        }
        res =bull+"A"+cow+"B";
       
        return res ;  
        
    }
}