class Solution {
     public int longestValidParentheses(String s) {
        char[] arr=s.toCharArray();
        int[] open=new int[arr.length];
        int[] close=new int[arr.length];

        //find opening parenth valid length
        int numOpen=0, numClose=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==')'){
                numClose++;
                if(numClose>numOpen){numOpen=0;numClose=0;}
            }else{
                numOpen++;
            }
            open[i]=numOpen;
        }


        //find closing parenth valid length
        numOpen=0;numClose=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==')'){
                numClose++;
            }else{
                numOpen++;
                if(numOpen>numClose){numOpen=0;numClose=0;}
            }
            close[i]=numClose;
        }
        
        //find the max valid seq
        int max=0;
        int curr=0;
        for(int i=0;i<arr.length;i++){
            if(open[i]!=0&&close[i]!=0){
                curr++;
                max=Math.max(max, curr);
            }else{
                curr=0;
            }
        }
        return max;
    }
}